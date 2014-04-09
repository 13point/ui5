/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.dao.ProductSettingDao;
import com.augmentum.ec.core.entity.ProductSetting;

/**
 * The Class ProductSettingDaoImpl.
 */
@Repository
public final class ProductSettingDaoImpl extends BaseCoreDaoImpl<ProductSetting> implements ProductSettingDao {

    /**
     * Instantiates a new product setting dao impl.
     */
    public ProductSettingDaoImpl() {
        setClazz(ProductSetting.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.dao.ProductSettingDao#getByProductIdsAndGroupIds(java.util.List,
     * java.lang.Integer[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ProductSetting> getByProductIdsAndGroupIds(final List<Integer> productIds, final Integer... groupIds) {

        boolean ifProductIds = !CollectionUtils.isEmpty(productIds);
        boolean ifGroupId = ArrayUtils.isEmpty(groupIds);

        if (!ifProductIds && !ifGroupId) {
            return new ArrayList<ProductSetting>();
        }

        Query query = null;

        if (ifProductIds && ifGroupId) {
            query = getEM(false).createNamedQuery("ProductSetting.getByProductIdsAndGroupIds", ProductSetting.class);
        } else if (ifProductIds) {
            query = getEM(false).createNamedQuery("ProductSetting.getByProductIds", ProductSetting.class);
        } else {
            query = getEM(false).createNamedQuery("ProductSetting.getByGroupIds", ProductSetting.class);
        }

        if (ifProductIds) {
            query.setParameter("productIds", productIds);
        }

        if (ifGroupId) {
            query.setParameter("groupIds", groupIds);
        }
        return query.getResultList();
    }
}
