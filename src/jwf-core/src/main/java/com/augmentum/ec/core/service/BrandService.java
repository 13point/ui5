/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.service;

import com.augmentum.ec.core.vo.BrandVO;
import com.augmentum.ec.core.vo.Pagination;
import com.augmentum.ec.core.vo.request.BrandListRequest;

/**
 * The Interface BrandService.
 */
public interface BrandService {

    /**
     * Gets the brands.
     *
     * @param brandListRequest the brand list request
     * @return the brands
     */
    Pagination<BrandVO> getBrands(BrandListRequest brandListRequest);
}
