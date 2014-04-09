/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.augmentum.ec.core.constant.UserStatus;
import com.augmentum.ec.core.dao.UserDao;
import com.augmentum.ec.core.entity.User;
import com.augmentum.ec.core.security.model.UserDetailsImpl;


/**
 * The Class UserDetailsServiceImpl.
 */
public final class UserDetailsServiceImpl implements UserDetailsManager {

    /** The user dao. */
    private UserDao userDao;

    /**
     * Sets the user dao.
     *
     * @param userDao the new user dao
     */
    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    /** The Constant ENABLED_USER. */
    private static final List<String> ENABLED_USER = new ArrayList<String>();

    static {
        ENABLED_USER.add(UserStatus.ACTIVE.getValue());
        ENABLED_USER.add(UserStatus.BANNED.getValue());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.
     * lang.String)
     */
    @Override
    @Transactional(value = "coreReadTransactionManager", readOnly = true, propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        User user = null;
        // get user by scUserId
        user = userDao.getById(name);
        if (user == null) {
            throw new UsernameNotFoundException("error_no_user");
        }
        // get user's scToken
        UserDetailsImpl details =
                new UserDetailsImpl(name, user.getPassword(), ENABLED_USER.contains(user.getStatus()), true, true, true,
                        formatAuthorities((long) (user.getUserTypeId())));
        details.setUserId(user.getUserId());
        details.setName(user.getName());
        details.setUserTypeId(user.getUserTypeId());

        return details;
    }

    /**
     * No need to implement this function.
     *
     * @param user the user
     */
    @Override
    @Deprecated
    public void createUser(final UserDetails user) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.provisioning.UserDetailsManager#updateUser(org.springframework
     * .security.core.userdetails.UserDetails)
     */
    @Override
    public void updateUser(final UserDetails user) {
        // TODO Auto-generated method stub

    }

    /**
     * No need to implement this function.
     *
     * @param username the username
     */
    @Override
    @Deprecated
    public void deleteUser(final String username) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.provisioning.UserDetailsManager#changePassword(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void changePassword(final String oldPassword, final String newPassword) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.provisioning.UserDetailsManager#userExists(java.lang.String)
     */
    @Override
    public boolean userExists(final String username) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Format authorities.
     *
     * @param userRoleId the user role id
     * @return the list
     */
    public List<GrantedAuthority> formatAuthorities(final Long userRoleId) {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();

        result.add(new SimpleGrantedAuthority(String.valueOf(userRoleId)));

        return result;
    }

}
