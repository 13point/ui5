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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.augmentum.ec.core.constant.ResponseCode;
import com.augmentum.ec.core.exception.DataValidationException;
import com.augmentum.ec.core.exception.ECExceptionFactory;
import com.augmentum.ec.core.service.ProductService;
import com.augmentum.ec.core.util.ResponseUtil;
import com.augmentum.ec.core.vo.request.ProductInventoryListRequest;
import com.augmentum.ec.core.vo.request.ProductListRequest;
import com.augmentum.ec.core.vo.request.ProductRequest;

/**
 * The Class ApiProductController.
 */
@Controller
public class ApiProductController extends ApiBaseController {

    /** The product service. */
    @Resource
    private ProductService productService;

    /**
     * Gets the products.
     *
     * @param productListRequest the product list request
     * @param validResult the valid result
     * @return the products
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "products", method = RequestMethod.GET,
            produces = { "application/json" })
    public final ResponseEntity<String> getProducts(
            @Valid final ProductListRequest productListRequest,
            final BindingResult validResult) throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(
                      DataValidationException.class,
                      ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(productService.getProducts(
                                        productListRequest), HttpStatus.OK);
    }

    /**
     * Gets the product detail.
     *
     * @param productId the product id
     * @return the product detail
     */
    @RequestMapping(value = "product/{productId}")
    public final ResponseEntity<String> getProductDetail(
                 @PathVariable("productId") final Integer productId) {
        return ResponseUtil.jsonSucceed(
                    productService.getProductDetail(productId),
                    HttpStatus.OK);
    }


    /**
     * Gets the inventory status list.
     *
     * @param productInventoryListRequest the product inventory list request
     * @param validResult the valid result
     * @return the inventory status list
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "product/inventory",
            method = RequestMethod.GET,
            produces = { "application/json" })
    public final ResponseEntity<String> getInventoryStatusList(
         @Valid final ProductInventoryListRequest productInventoryListRequest,
         final BindingResult validResult) throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(
                  DataValidationException.class,
                  ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(
               productService.getInventoryStatus(productInventoryListRequest),
               HttpStatus.OK);
    }

    /**
     * Gets the product detail by id.
     *
     * @param productRequest the product request
     * @param validResult the valid result
     * @return the product detail by id
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "product/detail",
        method = RequestMethod.GET,
        produces = { "application/json" })
    public final ResponseEntity<String> getProductDetailById(
                @Valid final ProductRequest productRequest,
                final BindingResult validResult)
                    throws DataValidationException {
        if (validResult.hasErrors()) {
            throw ECExceptionFactory.getException(
                      DataValidationException.class,
                      ResponseCode.INVALID_PARAMETER);
        }
        return ResponseUtil.jsonSucceed(
                   productService.getProductDetailById(productRequest),
                   HttpStatus.OK);
    }

    /**
     * Gets the linked product list.
     *
     * @param productId the product id
     * @param linkedType the linked type
     * @return the related product list
     * @throws DataValidationException the data validation exception
     */
    @RequestMapping(value = "products/{productId}/{linkedType}",
            method = RequestMethod.GET,
            produces = { "application/json" })
    public final ResponseEntity<String> getRelatedProductList(
                     @PathVariable final Integer productId,
                     @PathVariable final String linkedType)
                         throws DataValidationException {
        return ResponseUtil.jsonSucceed(
                   productService.getLinkedProductList(productId, linkedType),
                   HttpStatus.OK);
    }
}
