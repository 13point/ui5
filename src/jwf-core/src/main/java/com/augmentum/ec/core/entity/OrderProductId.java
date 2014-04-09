/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class OrderProductId.
 */
@Embeddable
public final class OrderProductId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7490946993570854922L;

    /** The order id. */
    private Integer orderId;

    /** The product id. */
    private Integer productId;

    /**
     * Instantiates a new order product id.
     */
    public OrderProductId() {
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    @Column(name = "order_id", nullable = false)
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * Sets the order id.
     *
     * @param orderId the new order id
     */
    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
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
        if (!(other instanceof OrderProductId)) {
            return false;
        }
        OrderProductId castOther = (OrderProductId) other;

        return (this.getOrderId() == castOther.getOrderId()) && (this.getProductId() == castOther.getProductId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (orderId != null ? orderId : 0);
        result = 37 * result + (productId != null ? productId : 0);
        return result;
    }

}
