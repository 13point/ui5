/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.ec.core.criteria.StoreCriteria;
import com.augmentum.ec.core.dao.StoreDao;
import com.augmentum.ec.core.entity.Store;
import com.augmentum.ec.core.service.StoreService;
import com.augmentum.ec.core.vo.StoreVO;
import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.request.StoreListRequest;

/**
 * The Class StoreServiceImpl.
 */
@Service
public final class StoreServiceImpl implements StoreService {

    /** The store dao. */
    @Resource
    private StoreDao storeDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.service.StoreService#getStores(com.augmentum.ec.core.vo.request.
     * StoreListRequest)
     */
    @Override
    public Pagination<StoreVO> getStores(final StoreListRequest storeListRequest) {
        StoreCriteria storeCriteria = StoreCriteria.generateFromRequest(storeListRequest);
        List<Store> stores = storeDao.queryStores(storeCriteria);
        int count = storeDao.countStores(storeCriteria);
        List<StoreVO> storeVOs = formatStores(stores);
        Pagination<StoreVO> pagination = new Pagination<StoreVO>(storeVOs, count);
        return pagination;
    }

    /**
     * Format stores.
     * 
     * @param stores the stores
     * @return the list
     */
    private List<StoreVO> formatStores(final List<Store> stores) {
        List<StoreVO> storeVOs = new ArrayList<StoreVO>();
        for (Store store : stores) {
            storeVOs.add(formatStore(store));
        }
        return storeVOs;
    }

    /**
     * Format store.
     * 
     * @param store the store
     * @return the store vo
     */
    private StoreVO formatStore(final Store store) {
        StoreVO storeVO = new StoreVO();
        storeVO.setStoreId(store.getStoreId());
        storeVO.setDepartmentId(store.getDepartmentId());
        storeVO.setName(store.getName());
        storeVO.setDescription(store.getDescription());
        storeVO.setPhone(store.getPhone());
        storeVO.setLocationId(store.getLocationId());
        storeVO.setAddress(store.getAddress());
        storeVO.setLongitude(store.getLongitude());
        storeVO.setLatitude(store.getLatitude());
        storeVO.setListed(store.isIsListed());
        storeVO.setCanSell(store.getCanSell());
        storeVO.setCreated(store.getCreated());
        storeVO.setUpdated(store.getUpdated());
        return storeVO;
    }

}
