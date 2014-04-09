/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * The Class UserDetailsImpl.
 */
public final class UserDetailsImpl extends User {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2005530624292693877L;

    /** The user id. */
    private Long userId;

    /** The name. */
    private String name;

    /** The user type id. */
    private Integer userTypeId;

    /**
     * Instantiates a new user details impl.
     *
     * @param username the username
     * @param password the password
     * @param enabled the enabled
     * @param accountNonExpired the account non expired
     * @param credentialsNonExpired the credentials non expired
     * @param accountNonLocked the account non locked
     * @param authorities the authorities
     */
    public UserDetailsImpl(final String username, final String password, final boolean enabled,
            final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked,
            final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the user type id.
     *
     * @return the user type id
     */
    public Integer getUserTypeId() {
        return userTypeId;
    }

    /**
     * Sets the user type id.
     *
     * @param userTypeId the new user type id
     */
    public void setUserTypeId(final Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}
