/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

import com.augmentum.ec.core.constant.ResponseStatus;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.util.SecurityUtil;
import com.google.gson.Gson;


/**
 * The Class AuthenticationFailureHandler.
 */
public final class AuthenticationFailureHandler implements
        org.springframework.security.web.authentication.AuthenticationFailureHandler {

    /** The default failure url. */
    private String defaultFailureUrl;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.AuthenticationFailureHandler#
     * onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.AuthenticationException)
     */
    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {
        String userAgent = request.getHeader("User-Agent");
        PrintWriter out = null;
        if (SecurityUtil.isWebClient(userAgent)) {
            String redirectPath = request.getContextPath() + defaultFailureUrl;
            request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
            response.sendRedirect(redirectPath);
        } else {
            out = response.getWriter();
            Map<String, Object> result = new HashMap<String, Object>();
            Map<String, Object> body = new HashMap<String, Object>();
            Map<String, Object> error = new HashMap<String, Object>();

            error.put(ResponseUtil.RESPONSE_ERROR_CODE, 10001);
            String[] msg = { " username or password incorrect " };
            error.put(ResponseUtil.RESPONSE_ERROR_MSG, msg);

            body.put(ResponseUtil.RESPONSE_ERROR, error);

            result.put(ResponseUtil.RESPONSE_BODY, body);
            result.put(ResponseUtil.RESPONSE_STATUS, ResponseStatus.FAILED.name());
            out.append(new Gson().toJson(result));
        }
    }

    /**
     * Gets the default failure url.
     * 
     * @return the default failure url
     */
    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    /**
     * Sets the default failure url.
     * 
     * @param defaultFailureUrl the new default failure url
     */
    public void setDefaultFailureUrl(final String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

}
