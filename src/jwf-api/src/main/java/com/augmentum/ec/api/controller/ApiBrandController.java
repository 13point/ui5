/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 31, 2014
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
import com.augmentum.ec.core.service.BrandService;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.vo.request.BrandListRequest;

/**
 * The Class ApiBrandController.
 */
@Controller
public class ApiBrandController extends ApiBaseController {

    /** The brand service. */
    @Resource
    private BrandService brandService;

    /**
     * Gets the brands.
     *
     * @param brandListRequest the brand list request
     * @param validResult the valid result
     * @return the brands
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "brands", method = RequestMethod.GET, produces = { "application/json" })
    public final ResponseEntity<String> getBrands(@Valid final BrandListRequest brandListRequest,
            final BindingResult validResult) throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(DataValidationException.class, ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(brandService.getBrands(brandListRequest), HttpStatus.OK);
    }
}
