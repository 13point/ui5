/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ProductSellStoreId.
 */
@Embeddable
public final class ProductSellStoreId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4411066096733728949L;

    /** The product id. */
    private Integer productId;

    /** The store id. */
    private Integer storeId;

    /**
     * Instantiates a new product sell store id.
     */
    public ProductSellStoreId() {
    }

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return this.productId;
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
     * Gets the store id.
     *
     * @return the store id
     */
    @Column(name = "store_id", nullable = false)
    public Integer getStoreId() {
        return this.storeId;
    }

    /**
     * Sets the store id.
     *
     * @param storeId the new store id
     */
    public void setStoreId(final Integer storeId) {
        this.storeId = storeId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ProductSellStoreId)) {
            return false;
        }
        ProductSellStoreId castOther = (ProductSellStoreId) other;

        return (this.getProductId() == castOther.getProductId()) && (this.getStoreId() == castOther.getStoreId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (productId != null ? productId : 0);
        result = 37 * result + (storeId != null ? storeId : 0);
        return result;
    }

}
