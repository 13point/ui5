/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.dao.ProductBrandDao;
import com.augmentum.ec.core.entity.ProductBrand;

/**
 * The Class ProductBrandDaoImpl.
 */
@Repository
public final class ProductBrandDaoImpl extends BaseCoreDaoImpl<ProductBrand> implements ProductBrandDao {

    /**
     * Instantiates a new product brand dao impl.
     */
    public ProductBrandDaoImpl() {
        setClazz(ProductBrand.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.dao.ProductBrandDao#getByProductIds(java.util.List)
     */
    @Override
    public List<ProductBrand> getByProductIds(final List<Integer> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return new ArrayList<ProductBrand>();
        }
        return getEM(false).createNamedQuery("ProductBrand.getByProductIds", ProductBrand.class)
                .setParameter("productIds", productIds).getResultList();
    }
}
