/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 11, 2013
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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.augmentum.ec.core.constant.ContentType;
import com.augmentum.ec.core.constant.ResponseStatus;
import com.augmentum.ec.core.util.ResponseUtil;
import com.google.gson.Gson;


/**
 * The Class JsonObjLogoutSuccessHandler.
 */
public class JsonObjLogoutSuccessHandler implements LogoutSuccessHandler {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess
     * (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public final void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        response.setContentType(ContentType.APPLICATION_JSON.getValue());
        PrintWriter writer = response.getWriter();
        try {
            writer = response.getWriter();
            Map<String, Object> result = new HashMap<String, Object>();
            result.put(ResponseUtil.RESPONSE_STATUS, ResponseStatus.SUCCEED.name());
            writer.append(new Gson().toJson(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
