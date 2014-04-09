/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 30, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.constant.SQL;
import com.augmentum.ec.core.criteria.BrandCriteria;
import com.augmentum.ec.core.criteria.QueryType;
import com.augmentum.ec.core.dao.BrandDao;
import com.augmentum.ec.core.entity.Brand;

/**
 * The Class BrandDaoImpl.
 */
@Repository
public final class BrandDaoImpl extends BaseCoreDaoImpl<Brand> implements BrandDao {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.augmentum.ec.core.dao.BrandDao#queryBrands(com.augmentum.ec.core.criteria.BrandCriteria)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Brand> queryBrands(final BrandCriteria brandCriteria) {
        return getQuery(brandCriteria, QueryType.ENTITY).getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.augmentum.ec.core.dao.BrandDao#countBrands(com.augmentum.ec.core.criteria.BrandCriteria)
     */
    @Override
    public int countBrands(final BrandCriteria brandCriteria) {
        BigInteger count = (BigInteger) getQuery(brandCriteria, QueryType.COUNT).getSingleResult();
        return count.intValue();
    }

    /**
     * Gets the query.
     * 
     * @param brandCriteria the brand criteria
     * @param queryType the query type
     * @return the query
     */
    private Query getQuery(final BrandCriteria brandCriteria, final QueryType queryType) {
        String keyword = brandCriteria.getKeyword();
        List<Integer> productIds = brandCriteria.getProductIds();
        Integer offset = brandCriteria.getOffset();
        Integer limit = brandCriteria.getLimit();

        boolean ifKeyword = StringUtils.isNotBlank(keyword);
        boolean ifProductIds = productIds != null && !productIds.isEmpty();
        boolean ifOffset = offset != null && offset > 0;
        boolean ifLimit = limit != null && limit > 0;

        StringBuilder sql = new StringBuilder();
        switch (queryType) {
            case ENTITY:
                sql.append("SELECT DISTINCT b.* FROM product_brand pb ");
                break;
            case COUNT:
                sql.append("SELECT COUNT(DISTINCT pb.brand_id) FROM product_brand pb ");
                break;
            default:
                break;
        }

        sql.append("INNER JOIN brand b ON b.brand_id = pb.brand_id ");

        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");

        if (ifKeyword) {
            sql.append("b.name LIKE :keyword or b.description LIKE :keyword ");
        }

        if (ifProductIds) {
            sql.append("pb.product_id IN (:productIds) ");
        }

        Query query = null;
        switch (queryType) {
            case ENTITY:
                query = getEM(true).createNativeQuery(sql.toString(), Brand.class);
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

    /*
     * (non-Javadoc)
     * 
     * @see com.augmentum.ec.core.dao.BrandDao#getByBrandIds(java.util.List)
     */
    @Override
    public List<Brand> getByBrandIds(final List<Integer> brandIds) {
        if (null == brandIds || brandIds.isEmpty()) {
            return new ArrayList<Brand>();
        }
        return getEM(false).createNamedQuery("Brand.getByBrandIds", Brand.class).setParameter("brandIds", brandIds)
                .getResultList();
    }

}
