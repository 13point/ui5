/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */

package com.augmentum.ec.core.dao;

import java.io.Serializable;


/**
 * The Interface BaseCoreDao.
 *
 * @param <T> the generic type
 */
public interface BaseCoreDao<T extends Serializable> extends BaseDao<T> {

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    T getById(final int id);

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    T getById(final String id);

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    T getById(final long id);

    /**
     * Update.
     *
     * @param entity the entity
     */
    void update(final T entity);

    /**
     * Delete.
     *
     * @param entity the entity
     */
    void delete(final T entity);

    /**
     * Delete by id.
     *
     * @param entityId the entity id
     */
    void deleteById(final int entityId);

    /**
     * Delete by id.
     *
     * @param entityId the entity id
     */
    void deleteById(final String entityId);

    /**
     * Delete by id.
     *
     * @param entityId the entity id
     */
    void deleteById(final long entityId);

    /**
     * Do flush.
     */
    void doFlush();

    /**
     * Refresh obj.
     *
     * @param entity the entity
     */
    void refreshObj(T entity);
}
