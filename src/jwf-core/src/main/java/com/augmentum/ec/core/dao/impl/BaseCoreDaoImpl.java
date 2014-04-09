/**
 * @author Firstname Lastname <your.email@address>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.augmentum.ec.core.dao.BaseCoreDao;


/**
 * The Class BaseCoreDaoImpl.
 *
 * @param <T> the generic type
 */
public abstract class BaseCoreDaoImpl<T extends Serializable> implements BaseCoreDao<T> {

    /** The entity manager. */
    @PersistenceContext(unitName = "core")
    protected EntityManager entityManager;

    /** The read entity manager. */
    @PersistenceContext(unitName = "core_read")
    protected EntityManager readEntityManager;

    /** The clazz. */
    protected Class<T> clazz;

    /**
     * Sets the clazz.
     *
     * @param clazz the new clazz
     */
    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#getById(int)
     */
    @Override
    public final T getById(final int id) {
        return getEM(false).find(clazz, id);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#getById(java.lang.String)
     */
    @Override
    public final T getById(final String id) {
        return getEM(false).find(clazz, id);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#getById(long)
     */
    @Override
    public final T getById(final long id) {
        return getEM(false).find(clazz, id);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#update(java.io.Serializable)
     */
    @Override
    public final void update(final T entity) {
        entityManager.merge(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#delete(java.io.Serializable)
     */
    @Override
    public final void delete(final T entity) {
        entityManager.remove(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#deleteById(int)
     */
    @Override
    public final void deleteById(final int entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#deleteById(java.lang.String)
     */
    @Override
    public final void deleteById(final String entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#deleteById(long)
     */
    @Override
    public final void deleteById(final long entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#doFlush()
     */
    @Override
    public final void doFlush() {
        entityManager.flush();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseDao#findAll()
     */
    @Override
    @SuppressWarnings("unchecked")
    public final List<T> findAll() {
        return getEM(false).createQuery("from " + clazz.getName()).getResultList();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseDao#save(java.io.Serializable)
     */
    @Override
    public final void save(final T entity) {
        entityManager.persist(entity);
    }

    /**
     * Gets the em.
     *
     * @param isReadOnly the is read only
     * @return the em
     */
    public final EntityManager getEM(final Boolean isReadOnly) {
        return isReadOnly ? this.readEntityManager : this.entityManager;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.augmentum.jwf.core.dao.BaseCoreDao#refreshObj(java.io.Serializable)
     */
    @Override
    public final void refreshObj(final T entity) {
        entityManager.refresh(entity);
    }
}
