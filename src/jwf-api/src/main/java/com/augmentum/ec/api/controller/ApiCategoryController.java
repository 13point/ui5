/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.api.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.augmentum.ec.core.constant.ResponseCode;
import com.augmentum.ec.core.exception.DataValidationException;
import com.augmentum.ec.core.exception.ECExceptionFactory;
import com.augmentum.ec.core.service.CategoryService;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.vo.request.CategoryListRequest;

/**
 * The Class ApiCategoryController.
 */
@Controller
public class ApiCategoryController extends ApiBaseController {

    /** The category service. */
    @Resource
    private CategoryService categoryService;

    /**
     * Gets the categories.
     *
     * @param categoryListRequest the category list request
     * @param validResult the valid result
     * @return the categories
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "categories", method = RequestMethod.GET, produces = { "application/json" })
    public final ResponseEntity<String> getCategories(@Valid final CategoryListRequest categoryListRequest,
            final BindingResult validResult) throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(DataValidationException.class, ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(categoryService.getCategoryList(categoryListRequest), HttpStatus.OK);
    }
}
