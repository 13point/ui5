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

import org.springframework.security.core.Authentication;

import com.augmentum.ec.core.constant.ResponseStatus;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.util.SecurityUtil;
import com.google.gson.Gson;


/**
 * The Class AuthenticationSuccessHandler.
 */
public final class AuthenticationSuccessHandler implements
        org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#
     * onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        String userAgent = request.getHeader("User-Agent");
        PrintWriter out = null;
        if (!SecurityUtil.isWebClient(userAgent)) {
            try {
                out = response.getWriter();
                Map<String, Object> result = new HashMap<String, Object>();
                result.put(ResponseUtil.RESPONSE_STATUS, ResponseStatus.SUCCEED.name());
                out.append(new Gson().toJson(result));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

}
