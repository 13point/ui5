/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.service;

import com.augmentum.ec.core.vo.StoreVO;
import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.request.StoreListRequest;

/**
 * The Interface BrandService.
 */
public interface StoreService {

    /**
     * Gets the brands.
     * 
     * @param storeListRequest the brand list request
     * @return the brands
     */
    Pagination<StoreVO> getStores(StoreListRequest storeListRequest);
}
