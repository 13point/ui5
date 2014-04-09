/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.ec.core.dao.UserDao;
import com.augmentum.ec.core.service.UserService;

/**
 * The Class UserSerivceImpl.
 */
@Service
public class UserSerivceImpl implements UserService {

    /** The user dao. */
    @Resource
    private UserDao userDao;

}
