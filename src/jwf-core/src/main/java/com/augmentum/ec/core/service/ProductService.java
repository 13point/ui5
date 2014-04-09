/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 31, 2014
 */
package com.augmentum.ec.core.service;

import java.util.List;

import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.ProductListVO;
import com.augmentum.ec.core.vo.ProductStockStoreVO;
import com.augmentum.ec.core.vo.ProductVO;
import com.augmentum.ec.core.vo.request.ProductInventoryListRequest;
import com.augmentum.ec.core.vo.request.ProductListRequest;
import com.augmentum.ec.core.vo.request.ProductRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductService.
 */
public interface ProductService {

    /**
     * Gets the products.
     *
     * @param productListRequest the product list request
     * @return the products
     */
    Pagination<ProductListVO> getProducts(
          ProductListRequest productListRequest);

    /**
     * Gets the product detail.
     *
     * @param productId the product id
     * @return the product detail
     */
    ProductVO getProductDetail(Integer productId);

    /**
     * Gets the inventory status.
     *
     * @param productInventoryListRequest the product inventory list request
     * @return the inventory status
     */
    Pagination<ProductStockStoreVO> getInventoryStatus(
               ProductInventoryListRequest productInventoryListRequest);

    /**
     * Gets the product detail by id.
     *
     * @param productRequest the product request
     * @return the product detail by id
     */
    ProductVO getProductDetailById(
            ProductRequest productRequest);

    /**
     * Gets the linked product list.
     *
     * @param productId the product id
     * @param linkedType the linked type
     * @return the linked product list
     */
    List<ProductListVO> getLinkedProductList(
             Integer productId, String linkedType);
}
