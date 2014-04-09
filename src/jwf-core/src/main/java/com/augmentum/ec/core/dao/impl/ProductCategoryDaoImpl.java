/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 8, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.augmentum.ec.core.dao.ProductCategoryDao;
import com.augmentum.ec.core.entity.ProductCategory;

/**
 * The Class ProductCategoryDaoImpl.
 */
public final class ProductCategoryDaoImpl extends BaseCoreDaoImpl<ProductCategory> implements ProductCategoryDao {

    /**
     * Instantiates a new product category dao impl.
     */
    public ProductCategoryDaoImpl() {
        setClazz(ProductCategory.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.dao.ProductCategoryDao#getByProductIds(java.util.List)
     */
    @Override
    public List<ProductCategory> getByProductIds(final List<Integer> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return new ArrayList<ProductCategory>();
        }
        return getEM(true).createNamedQuery("ProductCategory.getByProductIds", ProductCategory.class)
                .setParameter("productIds", productIds).getResultList();
    }

}
