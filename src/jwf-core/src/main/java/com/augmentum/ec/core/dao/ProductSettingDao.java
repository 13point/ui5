/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 2, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.entity.ProductSetting;

/**
 * The Interface ProductSettingDao.
 */
public interface ProductSettingDao extends BaseDao<ProductSetting> {

    /**
     * Gets the by product ids and group ids.
     * 
     * @param productIds the product ids
     * @param groupIds the group ids
     * @return the by product ids and group ids
     */
    List<ProductSetting> getByProductIdsAndGroupIds(List<Integer> productIds, Integer... groupIds);

}
