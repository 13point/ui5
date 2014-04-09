package com.augmentum.ec.core.criteria;

import com.augmentum.ec.core.vo.request.ProductInventoryListRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductInventoryCriteria.
 */
public final class ProductInventoryCriteria extends PaginationCriteria {

    /** The Constant DEFAULT_LIMIT. */
    private static final int DEFAULT_LIMIT = 1000;

    /** The product id. */
    private Integer productId;

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId the new product id
     */
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    /**
     * Gets the default limit.
     *
     * @return the default limit
     */
    public static int getDefaultLimit() {
        return DEFAULT_LIMIT;
    }

    /**
     * Gets the inventory query sql.
     *
     * @param request the request
     * @return the inventory query sql
     */
    public static ProductInventoryCriteria getInventoryQuerySql(
            final ProductInventoryListRequest request) {
        ProductInventoryCriteria criteria = new ProductInventoryCriteria();
        criteria.setProductId(request.getProductId());
        Integer offset = request.getOffset();
        criteria.setOffset(offset != null && offset <= 0 ? null : offset);
        Integer limit = request.getLimit();
        criteria.setLimit(limit == null || limit <= 0 ? DEFAULT_LIMIT : limit);
        return criteria;
    }
}
