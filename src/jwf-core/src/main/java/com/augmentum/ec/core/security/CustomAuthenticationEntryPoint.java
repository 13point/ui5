/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.augmentum.ec.core.util.SecurityUtil;


/**
 * The Class CustomAuthenticationEntryPoint.
 */
@SuppressWarnings("deprecation")
public final class CustomAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint#commence
     * (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.AuthenticationException)
     */
    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response,
            final org.springframework.security.core.AuthenticationException authException) throws IOException,
            ServletException {
        String xrequestedWith = request.getHeader("x-requested-with");
        String userAgent = request.getHeader("User-Agent");
        if (SecurityUtil.isWebClient(userAgent)) {
            if ((xrequestedWith != null) && xrequestedWith.equals("XMLHttpRequest") && (authException != null)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                super.commence(request, response, authException);
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
