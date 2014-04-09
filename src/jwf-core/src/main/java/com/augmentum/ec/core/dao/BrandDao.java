/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.criteria.BrandCriteria;
import com.augmentum.ec.core.entity.Brand;

/**
 * The Interface BrandDao.
 */
public interface BrandDao extends BaseCoreDao<Brand> {

    /**
     * Query brands.
     * 
     * @param brandCriteria the brand criteria
     * @return the list
     */
    List<Brand> queryBrands(BrandCriteria brandCriteria);

    /**
     * Count brands.
     * 
     * @param brandCriteria the brand criteria
     * @return the int
     */
    int countBrands(BrandCriteria brandCriteria);

    /**
     * Gets the by brand ids.
     * 
     * @param brandIds the brand ids
     * @return the by brand ids
     */
    List<Brand> getByBrandIds(List<Integer> brandIds);
}
