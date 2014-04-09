/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 1, 2014
 */
package com.augmentum.ec.core.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.augmentum.ec.core.constant.SQL;
import com.augmentum.ec.core.constant.Sort;
import com.augmentum.ec.core.criteria.ProductCriteria;
import com.augmentum.ec.core.criteria.ProductInventoryCriteria;
import com.augmentum.ec.core.criteria.QueryType;
import com.augmentum.ec.core.dao.ProductDao;
import com.augmentum.ec.core.entity.Product;
import com.augmentum.ec.core.entity.ProductStockStore;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductDaoImpl.
 */
@Repository
public final class ProductDaoImpl
            extends BaseCoreDaoImpl<Product> implements ProductDao {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.augmentum.ec.core.dao.ProductDao#queryProducts
     *          (com.augmentum.ec.core.criteria.ProductCriteria)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> queryProducts(final ProductCriteria productCriteria) {
        return getQuery(productCriteria, QueryType.ENTITY).getResultList();
    }


    /*
     * (non-Javadoc)
     * @see com.augmentum.ec.core.dao.ProductDao#queryLinkedProductList
     * (com.augmentum.ec.core.criteria.ProductCriteria)
     */
    @Override
    public List<Product> queryLinkedProductList(
               final ProductCriteria productCriteria) {
        return getLinkedProductListQuery(productCriteria).getResultList();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.augmentum.ec.core.dao.ProductDao#countProducts
     * (com.augmentum.ec.core.criteria.ProductCriteria)
     */
    @Override
    public int countProducts(final ProductCriteria productCriteria) {
        BigInteger count = (BigInteger) getQuery(productCriteria,
                                 QueryType.COUNT).getSingleResult();
        return count.intValue();
    }

    /**
     * Gets the query.
     *
     * @param productCriteria the product criteria
     * @param queryType the query type
     * @return the query
     */
    private Query getQuery(final ProductCriteria productCriteria,
                final QueryType queryType) {
        String keyword = productCriteria.getKeyword();
        List<Integer> brands = productCriteria.getBrands();
        List<Integer> categories = productCriteria.getCategories();
        Date startTime = productCriteria.getStartTime();
        Date endTime = productCriteria.getEndTime();
        Boolean hasStock = productCriteria.getHasStock();
        Boolean like = productCriteria.getLike();
        Integer location = productCriteria.getLocation();
        Float topPrice = productCriteria.getTopPrice();
        Float lowPrice = productCriteria.getLowPrice();
        Sort orderByCreated = productCriteria.getOrderByCreated();
        Sort orderByPrice = productCriteria.getOrderByPrice();
        Integer store = productCriteria.getStore();
        Boolean redeemStore = productCriteria.getRedeemStore();
        Boolean sellStore = productCriteria.getSellStore();
        Boolean needBarcode = productCriteria.getNeedBarcode();
        Integer offset = productCriteria.getOffset();
        Integer limit = productCriteria.getLimit();

        boolean ifKeyword = StringUtils.isNotBlank(keyword);
        boolean ifBrands = brands != null && !brands.isEmpty();
        boolean ifCategories = categories != null && !categories.isEmpty();
        boolean ifStartTime = startTime != null;
        boolean ifEndTime = endTime != null;
        boolean ifHasStock = hasStock != null;
        boolean ifLike = like != null;
        boolean ifLocation = location != null;
        boolean ifTopPrice = topPrice != null;
        boolean ifLowPrice = lowPrice != null;
        boolean ifStore = store != null;
        boolean ifRedeemStore = redeemStore != null;
        boolean ifSellStore = sellStore != null;
        boolean ifNeedBarcode = needBarcode != null;
        boolean ifOrderByCreated = orderByCreated != null;
        boolean ifOrderByPrice = orderByPrice != null;
        boolean ifOffset = offset != null;
        boolean ifLimit = limit != null;

        StringBuilder sql = new StringBuilder();
        switch (queryType) {
            case ENTITY:
                sql.append("SELECT DISTINCT p.* FROM product p ");
                break;
            case COUNT:
                sql.append("SELECT count(DISTINCT p.product_id) "
                         + "FROM product p ");
                break;
            default:
                break;
        }

        if (ifStore) {
            sql.append("LEFT JOIN product_sell_store pss "
                     + "ON pss.product_id = p.product_id "
                     + "AND pss.store_id = :store ");
            sql.append("LEFT JOIN product_redeem_store prs ");
            sql.append("ON prs.product_id = p.product_id "
                     + "AND prs.store_id = :store ");
        }

        if (ifBrands) {
            sql.append("INNER JOIN product_brand pb ON "
                     + "pb.product_id = p.product_id "
                     + "AND pb.brand_id IN (:brands) ");
        }

        if (ifLike) {
            sql.append("INNER JOIN user_product up ON "
                     + "up.product_id = p.product_id AND user_id = :userId ");
        }

        sql.append(SQL.WHERE);
        sql.append("p.is_listed = true ");

        if (ifKeyword) {
            sql.append("AND p.name LIKE :keyword ");
        }

        if (ifStore) {
            sql.append("AND (pss.store_id = :store OR prs.store_id = :store) ");

        }

        if (ifTopPrice) {
            sql.append("AND p.price < :topPrice ");
        }

        if (ifLowPrice) {
            sql.append("AND p.price > :lowPrice ");
        }

        if (ifStartTime) {
            sql.append("AND p.start_datetime > :startTime ");
        }

        if (ifEndTime) {
            sql.append("AND p.start_datetime < :endTime ");
        }

        if (ifSellStore) {
            sql.append("AND p.sell_store_limit = :sellStore ");
        }

        if (ifRedeemStore) {
            sql.append("AND p.redeem_store_limit = :redeemStore ");
        }

        if (ifHasStock) {
            sql.append("AND p.has_stock = :hasStock ");
        }

        if (ifNeedBarcode) {
            sql.append("AND p.need_barcode = :needBarcode ");
        }

        if (ifCategories) {
            sql.append("AND p.category_id IN (:categories) ");
        }

        Query query = null;
        switch (queryType) {
            case ENTITY:
                sql.append(SQL.ORDER_BY);

                boolean ifOrdered = false;

                if (!ifOrderByCreated && !ifOrderByPrice) {
                    sql.append("p.position DESC ");
                    ifOrdered = true;
                } else if (ifOrderByPrice) {
                    if (ifOrdered) {
                        sql.append(",");
                    } else {
                        ifOrdered = true;
                    }
                    sql.append("p.price");
                    sql.append(orderByPrice.getGrammar());
                } else if (ifOrderByCreated) {
                    if (ifOrdered) {
                        sql.append(",");
                    } else {
                        ifOrdered = true;
                    }
                    sql.append(",p.start_datetime");
                    sql.append(orderByCreated.getGrammar());
                }


                query = getEM(true).createNativeQuery(
                          sql.toString(), Product.class);

                if (ifOffset) {
                    query.setFirstResult(offset);
                }

                if (ifLimit) {
                    query.setMaxResults(limit);
                }
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

        if (ifBrands) {
            query.setParameter("brands", brands);
        }

        if (ifCategories) {
            query.setParameter("categories", categories);
        }

        if (ifStartTime) {
            query.setParameter("startTime", startTime);
        }

        if (ifEndTime) {
            query.setParameter("endTime", endTime);
        }

        if (ifHasStock) {
            query.setParameter("hasStock", hasStock);
        }

        if (ifLocation) {
            query.setParameter("location", location);
        }

        if (ifTopPrice) {
            query.setParameter("topPrice", topPrice);
        }

        if (ifLowPrice) {
            query.setParameter("lowPrice", lowPrice);
        }

        if (ifStore) {
            query.setParameter("store", store);
        }

        if (ifSellStore) {
            query.setParameter("sellStore", sellStore);
        }

        if (ifRedeemStore) {
            query.setParameter("redeemStore", redeemStore);
        }

        if (ifNeedBarcode) {
            query.setParameter("needBarcode", needBarcode);
        }

        return query;
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec.core.dao.ProductDao#queryInventoryStatusList
     * (com.augmentum.ec.core.criteria.ProductInventoryCriteria)
     */
    @Override
    public List<ProductStockStore> queryInventoryStatusList(
            final ProductInventoryCriteria criteria) {
        Query query = this.getInventoryStatusQuery(
                           criteria, QueryType.ENTITY);
        // query.getResultList();
        return query.getResultList();
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec.core.dao.ProductDao#getProductDetailById
     * (com.augmentum.ec.core.criteria.ProductCriteria)
     */
    @Override
    public Product getProductDetailById(
            final ProductCriteria criteria) {
        Query query = this.getProductDetailQuery(criteria);
        return (Product) query.getSingleResult();
    }

    /* (non-Javadoc)
     * @see com.augmentum.ec.core.dao.ProductDao#countInventoryStatus
     * (com.augmentum.ec.core.criteria.ProductInventoryCriteria)
     */
    @Override
    public Integer countInventoryStatus(
            final ProductInventoryCriteria criteria) {
        BigInteger count = (BigInteger)
                getInventoryStatusQuery(criteria,
                QueryType.COUNT).getSingleResult();
        return count.intValue();
    }

    /**
     * Gets the inventory status query.
     *
     * @param criteria the criteria
     * @param queryType the query type
     * @return the inventory status query
     */
    private Query getInventoryStatusQuery(
            final ProductInventoryCriteria criteria,
            final QueryType queryType) {
        Integer productId = criteria.getProductId();
        Integer offset = criteria.getOffset();
        Integer limit = criteria.getLimit();

        boolean ifProductId = productId != null;
        boolean ifOffset = offset != null && offset > 0;
        boolean ifLimit = limit != null && limit > 0;

        StringBuilder sql = new StringBuilder();
        switch (queryType) {
        case ENTITY:
            sql.append("SELECT store.store_id,store.name,"
                 + "stock.qty_available,stock.product_id,"
                 + "stock.created,stock.qty,stock.qty_pending,"
                 + "stock.qty_sold,stock.store_id FROM store store");
            break;
        case COUNT:
            sql.append("SELECT COUNT(*) FROM store store");
            break;
        default:
            break;
        }

        sql.append(" INNER JOIN product_stock_store stock ON"
                + " store.store_id = stock.store_id");

        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");

        if (ifProductId) {
            sql.append(" AND stock.product_id=:productId");
        }

        Query query = null;
        switch (queryType) {
        case ENTITY:
            query = getEM(true).createNativeQuery(sql.toString(),
                          ProductStockStore.class);
            break;
        case COUNT:
            query = getEM(true).createNativeQuery(sql.toString());
            break;
        default:
            break;
        }

        if (ifProductId) {
            query.setParameter("productId", productId);
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

    /**
     * Gets the product detail query.
     *
     * @param criteria the criteria
     * @return the product detail query
     */
    private Query getProductDetailQuery(final ProductCriteria criteria) {
        Integer productId = criteria.getProductId();
        boolean ifProductId = productId != null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.* FROM product p");
        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");

        if (ifProductId) {
            sql.append(" AND p.product_id=:productId");
        }

        sql.append(" AND p.is_active=1 ");

        Query query = null;
        query = getEM(true).createNativeQuery(
                  sql.toString(), Product.class);

        if (ifProductId) {
            query.setParameter("productId", productId);
        }

        return query;
    }

    /**
     * Gets the linked product list query.
     *
     * @param criteria the criteria
     * @return the linked product list query
     */
    private Query getLinkedProductListQuery(
            final ProductCriteria criteria) {
        Integer productId = criteria.getProductId();
        boolean ifProductId = productId != null;
        String linkedType = null;
        if (criteria.getLinkedType() != null) {
            linkedType = criteria.getLinkedType();
        } else {
            linkedType = "";
        }

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT product.*,c.name categoryName "
                  + "FROM product product ");
        sql.append(" LEFT OUTER JOIN category c ON "
                  + "product.category_id=c.category_id ");
        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");
        sql.append(" AND product.product_id IN");
        sql.append(" ( ");

        sql.append(" SELECT pl.linked_product_id FROM product_link pl");
        sql.append(" INNER JOIN product p ON "
                + "p.product_id=pl.product_id ");
        sql.append(SQL.WHERE);
        sql.append(" 1 = 1 ");
        if (ifProductId) {
            sql.append(" AND p.product_id=:productId");
        }
        sql.append(" AND pl.type=:type ");
        sql.append(" AND p.is_active=1 ");

        sql.append(" )");
        sql.append(" ORDER BY product.position DESC");

        Query query = null;
        query = getEM(true).createNativeQuery(
                  sql.toString(), Product.class);

        if (ifProductId) {
            query.setParameter("productId", productId);
        }

        query.setParameter("type", linkedType);

        return query;
    }

}
