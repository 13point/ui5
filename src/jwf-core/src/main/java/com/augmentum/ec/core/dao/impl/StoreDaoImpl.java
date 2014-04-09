/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.constant.SQL;
import com.augmentum.ec.core.criteria.StoreCriteria;
import com.augmentum.ec.core.criteria.QueryType;
import com.augmentum.ec.core.dao.StoreDao;
import com.augmentum.ec.core.entity.Store;

/**
 * The Class StoreDaoImpl.
 */
@Repository
public final class StoreDaoImpl extends BaseCoreDaoImpl<Store> implements StoreDao {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.augmentum.ec.core.dao.StoreDao#queryStores(com.augmentum.ec.core.criteria.StoreCriteria)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Store> queryStores(final StoreCriteria storeCriteria) {
        return getQuery(storeCriteria, QueryType.ENTITY).getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.augmentum.ec.core.dao.StoreDao#countStores(com.augmentum.ec.core.criteria.StoreCriteria)
     */
    @Override
    public int countStores(final StoreCriteria storeCriteria) {
        BigInteger count = (BigInteger) getQuery(storeCriteria, QueryType.COUNT).getSingleResult();
        return count.intValue();
    }

    /**
     * Gets the query.
     * 
     * @param storeCriteria the store criteria
     * @param queryType the query type
     * @return the query
     */
    private Query getQuery(final StoreCriteria storeCriteria, final QueryType queryType) {
        String keyword = storeCriteria.getKeyword();
        List<Integer> productIds = storeCriteria.getProductIds();
        Boolean hasStock = storeCriteria.getHasStock();
        Integer departmentId = storeCriteria.getDepartmentId();
        BigDecimal longitide = storeCriteria.getLongitude();
        BigDecimal latitude = storeCriteria.getLatitude();
        Integer distance = storeCriteria.getDistance();
        Integer offset = storeCriteria.getOffset();
        Integer limit = storeCriteria.getLimit();

        boolean ifKeyword = StringUtils.isNotBlank(keyword);
        boolean ifProductIds = productIds != null && !productIds.isEmpty();
        boolean ifHasStock = hasStock != null;
        boolean ifDepartment = departmentId != null && departmentId > 0;
        boolean ifOffset = offset != null && offset > 0;
        boolean ifLimit = limit != null && limit > 0;
        boolean ifNearby = longitide != null && latitude != null;

        StringBuilder sql = new StringBuilder();
        switch (queryType) {
            case ENTITY:
                sql.append("SELECT DISTINCT t2.* FROM (");
                break;
            case COUNT:
                sql.append("SELECT COUNT(DISTINCT t2.store_id) FROM (");
                break;
            default:
                break;
        }
        if (ifNearby) {
            sql.append("SELECT *");
            sql.append(" , floor(d)*111000");
            sql.append(" + floor(mod(d,1)*60)*1850");
            sql.append(" + floor(mod(mod(d,1)*60,1)*60)*30.9 distance");
            sql.append(" FROM (");

            sql.append("SELECT DISTINCT c.* ");
            sql.append(", SQRT(POW( ABS( c.lat - :latitude), 2) + POW( ABS(c.long - :longitide), 2 )) AS d ");
            sql.append("FROM product a ");
        } else {
            sql.append("SELECT DISTINCT c.* FROM product a ");
        }

        sql.append("INNER JOIN product_stock_store b on b.product_id = a.product_id ");
        sql.append("INNER JOIN store c on c.store_id = b.store_id ");

        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");

        if (ifKeyword) {
            sql.append("and (c.name LIKE :keyword or c.description LIKE :keyword) ");
        }

        if (ifDepartment) {
            sql.append("and c.department_id = :departmentId");
        }

        if (ifProductIds) {
            sql.append("and a.product_id IN (:productIds) ");
        }

        if (ifHasStock) {
            if (hasStock) {
                sql.append("and b.qty_available > 0 ");
            } else {
                sql.append("and b.qty_available = 0 ");
            }
        }

        if (ifNearby) {
            sql.append(") t1) t2");
            sql.append(SQL.WHERE);
            sql.append(" distance < :distance ");
        } else {
            sql.append(") t2");
        }

        Query query = null;
        switch (queryType) {
            case ENTITY:
                query = getEM(true).createNativeQuery(sql.toString(), Store.class);
                break;
            case COUNT:
                query = getEM(true).createNativeQuery(sql.toString());
                break;
            default:
                break;
        }

        if (ifKeyword) {
            query.setParameter("keyword", "%" + keyword + "%");
        }

        if (ifProductIds) {
            query.setParameter("productIds", productIds);
        }

        if (ifDepartment) {
            query.setParameter("departmentId", departmentId);
        }

        if (ifNearby) {
            query.setParameter("latitude", latitude);
            query.setParameter("longitide", longitide);
            query.setParameter("distance", distance);
        }

        switch (queryType) {
            case ENTITY:
                if (ifOffset) {
                    query.setFirstResult(offset);
                }
                if (ifLimit) {
                    query.setMaxResults(limit);
                }
                break;
            default:
                break;
        }

        return query;
    }

}
