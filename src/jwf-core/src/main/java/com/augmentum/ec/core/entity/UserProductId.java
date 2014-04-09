/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class UserProductId.
 */
@Embeddable
public final class UserProductId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4860494638691737270L;

    /** The user id. */
    private Long userId;

    /** The product id. */
    private Integer productId;

    /**
     * Instantiates a new user product id.
     */
    public UserProductId() {
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
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
        if (!(other instanceof UserProductId)) {
            return false;
        }
        UserProductId castOther = (UserProductId) other;

        return (this.getUserId() == castOther.getUserId()) && (this.getProductId() == castOther.getProductId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (userId != null ? userId.intValue() : 0);
        result = 37 * result + (productId != null ? productId : 0);
        return result;
    }

}
