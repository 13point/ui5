/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */

package com.augmentum.ec.core.dao;

import java.io.Serializable;
import java.util.List;


/**
 * The Interface BaseDao.
 *
 * @param <T> the generic type
 */
public interface BaseDao<T extends Serializable> {

    /**
     * Find all.
     *
     * @return the list
     */
    List<T> findAll();

    /**
     * Save.
     *
     * @param entity the entity
     */
    void save(final T entity);
}
