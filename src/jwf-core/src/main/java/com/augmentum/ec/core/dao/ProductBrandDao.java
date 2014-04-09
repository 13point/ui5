/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.entity.ProductBrand;

/**
 * The Interface ProductBrandDao.
 */
public interface ProductBrandDao extends BaseDao<ProductBrand> {

    /**
     * Gets the by product ids.
     * 
     * @param productIds the product ids
     * @return the by product ids
     */
    List<ProductBrand> getByProductIds(List<Integer> productIds);

}
