/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
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
import com.augmentum.ec.core.service.StoreService;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.vo.request.StoreListRequest;

/**
 * The Class ApiStoreController.
 */
@Controller
public class ApiStoreController extends ApiBaseController {

    /** The store service. */
    @Resource
    private StoreService storeService;

    /**
     * Gets the stores.
     * 
     * @param storeListRequest the store list request
     * @param validResult the valid result
     * @return the stores
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "stores", method = RequestMethod.GET, produces = { "application/json" })
    public final ResponseEntity<String> getStores(@Valid final StoreListRequest storeListRequest,
            final BindingResult validResult) throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(DataValidationException.class, ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(storeService.getStores(storeListRequest), HttpStatus.OK);
    }
}
