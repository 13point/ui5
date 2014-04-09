/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.dao.UserDao;
import com.augmentum.ec.core.entity.User;

/**
 * The Class UserDaoImpl.
 */
@Repository
public final class UserDaoImpl extends BaseCoreDaoImpl<User> implements UserDao {

    /**
     * Instantiates a new user dao impl.
     */
    public UserDaoImpl() {
        setClazz(User.class);
    }

}
