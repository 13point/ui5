/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.api.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import com.augmentum.ec.core.service.UserService;

/**
 * The Class ApiAccountController.
 */
@Controller
public class ApiAccountController extends ApiBaseController {

    /** The user service. */
    @Resource
    private UserService userService;

}
