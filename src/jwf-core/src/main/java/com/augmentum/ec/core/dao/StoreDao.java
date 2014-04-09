/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.criteria.StoreCriteria;
import com.augmentum.ec.core.entity.Store;

/**
 * The Interface StoreDao.
 */
public interface StoreDao extends BaseCoreDao<Store> {

    /**
     * Query stores.
     * 
     * @param storeCriteria the store criteria
     * @return the list
     */
    List<Store> queryStores(StoreCriteria storeCriteria);

    /**
     * Count stores.
     * 
     * @param storeCriteria the store criteria
     * @return the int
     */
    int countStores(StoreCriteria storeCriteria);
}
