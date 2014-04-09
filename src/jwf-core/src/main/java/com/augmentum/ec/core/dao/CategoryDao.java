/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.dao;

import java.util.List;

import com.augmentum.ec.core.criteria.CategoryCriteria;
import com.augmentum.ec.core.entity.Category;


/**
 * The Interface CategoryDao.
 */
public interface CategoryDao extends BaseCoreDao<Category> {

    /**
     * Query categories.
     *
     * @param categoryCriteria the category criteria
     * @return the list
     */
    List<Category> queryCategories(CategoryCriteria categoryCriteria);

}
