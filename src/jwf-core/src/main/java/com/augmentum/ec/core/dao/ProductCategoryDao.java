/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 8, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.entity.ProductCategory;

/**
 * The Interface ProductCategoryDao.
 */
public interface ProductCategoryDao extends BaseDao<ProductCategory> {

    /**
     * Gets the by product ids.
     * 
     * @param productIds the product ids
     * @return the by product ids
     */
    List<ProductCategory> getByProductIds(List<Integer> productIds);
}
