/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.security.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.augmentum.ec.core.constant.GlobalProperties;
import com.augmentum.ec.core.constant.SessionKey;


/**
 * The Class RequestHeaderCheckingTokenBasedRememberMeServices.
 */
@SuppressWarnings("deprecation")
public final class RequestHeaderCheckingTokenBasedRememberMeServices extends TokenBasedRememberMeServices {

    /** The custom remember me cookie key. */
    private static final String CUSTOM_REMEMBERME_COOKIE_KEY = StringUtils
            .hasText(GlobalProperties.AUTO_LOGIN_TOKEN_KEY)
            ? GlobalProperties.AUTO_LOGIN_TOKEN_KEY
            : "WEB_FRAMEWORK_TOKEN";

    /** The Constant THOUSAND. */
    public static final Long THOUSAND = 1000L;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices#
     * onLoginSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public void onLoginSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication successfulAuthentication) {
        // do set cookie operator
        String username = retrieveUserName(successfulAuthentication);

        if (!StringUtils.hasLength(username)) {
            return;
        }

        long expiryTime = System.currentTimeMillis() + (SessionKey.SESSION_VALIDITY_TIME * THOUSAND);

        String signatureValue = makeTokenSignature(expiryTime, username, null);

        String tokenValue = encodeCookie(new String[] { username, Long.toString(expiryTime), signatureValue });
        response.setHeader(CUSTOM_REMEMBERME_COOKIE_KEY, tokenValue);

        request.getSession().setAttribute(CUSTOM_REMEMBERME_COOKIE_KEY, tokenValue);

        setCustomRememberMeCookie(response, tokenValue);
        if (logger.isDebugEnabled()) {
            logger.debug("Added remember-me cookie for user '" + username + "', " + "expiry: '" + new Date(expiryTime)
                    + "'");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices#
     * processAutoLoginCookie(java.lang.String[], javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected UserDetails processAutoLoginCookie(final String[] cookieTokens, final HttpServletRequest request,
            final HttpServletResponse response) {
        String rememberCookie = extractRememberMeCookie(request);
        if (rememberCookie == null) {
            // No series match, so we can't authenticate using this cookie
            throw new RememberMeAuthenticationException("No remember-me cookie found ");
        }

        if (cookieTokens.length != 3) {
            throw new InvalidCookieException("Cookie token did not contain 3" + " cookieTokens, but contained '"
                    + Arrays.asList(cookieTokens) + "'");
        }

        long tokenExpiryTime;

        try {
            tokenExpiryTime = new Long(cookieTokens[1]).longValue();
        } catch (NumberFormatException nfe) {
            throw new InvalidCookieException("Cookie token[1] did not contain a valid number (contained '"
                    + cookieTokens[1] + "')");
        }

        if (isTokenExpired(tokenExpiryTime)) {
            throw new InvalidCookieException("Cookie token[1] has expired (expired on '" + new Date(tokenExpiryTime)
                    + "'; current time is '" + new Date() + "')");
        }

        UserDetails userDetails = getUserDetailsService().loadUserByUsername(cookieTokens[0]);
        String expectedTokenSignature = makeTokenSignature(tokenExpiryTime, userDetails.getUsername(), null);
        if (!equals(expectedTokenSignature, cookieTokens[2])) {
            throw new InvalidCookieException("Cookie token[2] contained signature '" + cookieTokens[2]
                    + "' but expected '" + expectedTokenSignature + "'");
        }

        return userDetails;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices#logout
     * (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public void logout(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) {
        if (logger.isDebugEnabled()) {
            logger.debug("Logout of user " + (authentication == null ? "Unknown" : authentication.getName()));
        }
        cancelCookie(request, response);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices#
     * cancelCookie(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void cancelCookie(final HttpServletRequest request, final HttpServletResponse response) {
        logger.debug("Cancelling cookie");

        response.addHeader(CUSTOM_REMEMBERME_COOKIE_KEY, null);
        invalidateRememberMeCookie(response);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices#
     * extractRememberMeCookie(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected String extractRememberMeCookie(final HttpServletRequest request) {
        String token = null;
        token = getCookieValue(request, CUSTOM_REMEMBERME_COOKIE_KEY);
        if (token == null) {
            token = request.getHeader(CUSTOM_REMEMBERME_COOKIE_KEY);
        }

        return token;
    }

    /**
     * Gets the cookie value.
     * 
     * @param request the request
     * @param name the name
     * @return the cookie value
     */
    public String getCookieValue(final HttpServletRequest request, final String name) {
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if ((cookies != null) && (name != null)) {
            for (int i = 0; i < cookies.length; i++) {
                if (name.equals(cookies[i].getName())) {
                    cookieValue = cookies[i].getValue();
                }
            }
        }
        return cookieValue;
    }

    /**
     * Sets the custom remember me cookie.
     * 
     * @param response the response
     * @param value the value
     */
    protected void setCustomRememberMeCookie(final HttpServletResponse response, final String value) {
        Cookie c = new Cookie(CUSTOM_REMEMBERME_COOKIE_KEY, value);
        c.setMaxAge(SessionKey.SESSION_VALIDITY_TIME);
        c.setPath("/");
        boolean setHttpOnlyMethod = ReflectionUtils.findMethod(Cookie.class, "setHttpOnly", boolean.class) != null;
        if (setHttpOnlyMethod) {
            c.setHttpOnly(true);
        }

        response.addCookie(c);
    }

    /**
     * Invalidate remember me cookie.
     * 
     * @param response the response
     */
    private void invalidateRememberMeCookie(final HttpServletResponse response) {
        Cookie cookie = new Cookie(CUSTOM_REMEMBERME_COOKIE_KEY, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        boolean setHttpOnlyMethod = ReflectionUtils.findMethod(Cookie.class, "setHttpOnly", boolean.class) != null;
        if (setHttpOnlyMethod) {
            cookie.setHttpOnly(true);
        }
        response.addCookie(cookie);
    }

    /**
     * Equals.
     * 
     * @param expected the expected
     * @param actual the actual
     * @return true, if successful
     */
    private boolean equals(final String expected, final String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        if (expectedBytes.length != actualBytes.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < expectedBytes.length; i++) {
            result |= expectedBytes[i] ^ actualBytes[i];
        }
        return result == 0;
    }

    /**
     * Bytes utf8.
     * 
     * @param s the s
     * @return the byte[]
     */
    private byte[] bytesUtf8(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not get bytes in UTF-8 format", e);
        }
    }

}
