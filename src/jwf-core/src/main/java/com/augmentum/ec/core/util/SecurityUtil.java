/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.util.ReflectionUtils;

import com.augmentum.ec.core.constant.GlobalProperties;
import com.augmentum.ec.core.constant.SessionKey;

/**
 * The Class SecurityUtil.
 */
public final class SecurityUtil {

    /** The Constant KEY. */
    private static final String KEY = "springRocks";

    /** The Constant DELIMITER. */
    private static final String DELIMITER = ":";

    /** The Constant TOKEN_LIFT_TIME. */
    private static final int TOKEN_LIFT_TIME = 60 * 60 * 24 * 365;

    /** The Constant THOUSAND. */
    private static final Long THOUSAND = 1000L;

    /**
     * Instantiates a new security util.
     */
    private SecurityUtil() {
        // empty
    }

    /**
     * Checks if is web client.
     *
     * @param userAgent the user agent
     * @return true, if is web client
     */
    public static boolean isWebClient(final String userAgent) {
        boolean isWebClient = false;
        if (userAgent != null) {
            if ((userAgent.indexOf("Mozilla") != -1) || (userAgent.indexOf("AppleWebKit") != -1)
                    || (userAgent.indexOf("Chrome") != -1) || (userAgent.indexOf("Safari") != -1)) {
                isWebClient = true;
            }
        }
        return isWebClient;
    }

    /**
     * Checks if is web client.
     *
     * @param request the request
     * @return true, if is web client
     */
    public static boolean isWebClient(final HttpServletRequest request) {
        boolean isWebClient = false;
        if (request != null) {
            String userAgent = request.getHeader("User-Agent");
            isWebClient = isWebClient(userAgent);
        }
        return isWebClient;
    }

    /**
     * Sets the custom remember me cookie.
     *
     * @param response the response
     * @param value the value
     */
    public static void setCustomRememberMeCookie(final HttpServletResponse response, final String value) {
        if (StringUtils.isNotEmpty(GlobalProperties.AUTO_LOGIN_TOKEN_KEY)) {
            Cookie c = new Cookie(GlobalProperties.AUTO_LOGIN_TOKEN_KEY, value);
            c.setMaxAge(TOKEN_LIFT_TIME);
            c.setPath("/");
            boolean setHttpOnlyMethod = ReflectionUtils.findMethod(Cookie.class, "setHttpOnly", boolean.class) != null;
            if (setHttpOnlyMethod) {
                c.setHttpOnly(true);
            }
            response.addCookie(c);
        }
    }

    /**
     * Calculates the digital signature to be put in the cookie. Default value is MD5
     * ("username:tokenExpiryTime:password:key")
     *
     * @param tokenExpiryTime the token expiry time
     * @param username the username
     * @param password the password
     * @return the string
     */
    protected static String
            makeTokenSignature(final long tokenExpiryTime, final String username, final String password) {
        String data = username + ":" + tokenExpiryTime + ":" + password + ":" + KEY;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available!");
        }

        return new String(Hex.encode(digest.digest(data.getBytes())));
    }

    /**
     * Inverse operation of decodeCookie.
     *
     * @param cookieTokens the tokens to be encoded.
     * @return base64 encoding of the tokens concatenated with the ":" delimiter.
     */
    protected static String encodeCookie(final String[] cookieTokens) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cookieTokens.length; i++) {
            sb.append(cookieTokens[i]);

            if (i < cookieTokens.length - 1) {
                sb.append(DELIMITER);
            }
        }

        String value = sb.toString();

        sb = new StringBuilder(new String(Base64.encode(value.getBytes())));

        while (sb.charAt(sb.length() - 1) == '=') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * Gets the client token.
     *
     * @param username the username
     * @param password the password
     * @return the web client token
     */
    public static String getClientToken(final String username, final String password) {
        long expiryTime = System.currentTimeMillis() + SessionKey.SESSION_VALIDITY_TIME * THOUSAND;
        String token =
                encodeCookie(new String[] { username, Long.toString(expiryTime),
                    makeTokenSignature(expiryTime, username, password) });
        return token;
    }

    /**
     * Sets the auto login token.
     *
     * @param username the username
     * @param request the request
     * @param response the response
     */
    public static void setAutoLoginToken(final String username, final HttpServletRequest request,
            final HttpServletResponse response) {
        String tokenValue = getClientToken(username, null);
        setCustomRememberMeCookie(response, tokenValue);
    }

    /**
     * Login.
     *
     * @param details the details
     * @param request the request
     * @param response the response
     * @param session the session
     */
    public static void login(final UserDetails details, final HttpServletRequest request,
            final HttpServletResponse response, final HttpSession session) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(details, details.getPassword(), null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        SecurityUtil.setAutoLoginToken(details.getUsername(), request, response);
        session.setAttribute("login", true);
    }

}
