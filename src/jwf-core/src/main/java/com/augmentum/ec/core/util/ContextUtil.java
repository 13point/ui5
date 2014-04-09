/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 2014-01-15
 */
package com.augmentum.ec.core.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.augmentum.ec.core.security.model.UserDetailsImpl;

/**
 * The Class ContextUtil.
 */
public final class ContextUtil {

    /**
     * Instantiates a new context util.
     */
    private ContextUtil() {
    }

    /**
     * Gets the security context.
     *
     * @return the security context
     */
    public static SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    /**
     * Gets the user detail.
     *
     * @return the user detail
     */
    public static UserDetailsImpl getUserDetail() {
        Authentication authentication = getSecurityContext().getAuthentication();
        if (null != authentication) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetailsImpl) {
                return (UserDetailsImpl) principal;
            }
        }
        return null;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public static long getUserId() {
        UserDetailsImpl userDetails = getUserDetail();
        if (null != userDetails) {
            return userDetails.getUserId();
        }
        return -1;
    }

}
