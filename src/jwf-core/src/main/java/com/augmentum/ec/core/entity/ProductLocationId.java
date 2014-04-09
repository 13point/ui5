/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ProductLocationId.
 */
@Embeddable
public final class ProductLocationId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2992555476957504176L;

    /** The product id. */
    private Integer productId;

    /** The location id. */
    private Integer locationId;

    /**
     * Instantiates a new product location id.
     */
    public ProductLocationId() {
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
     * Gets the location id.
     *
     * @return the location id
     */
    @Column(name = "location_id", nullable = false)
    public Integer getLocationId() {
        return this.locationId;
    }

    /**
     * Sets the location id.
     *
     * @param locationId the new location id
     */
    public void setLocationId(final Integer locationId) {
        this.locationId = locationId;
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
        if (!(other instanceof ProductLocationId)) {
            return false;
        }
        ProductLocationId castOther = (ProductLocationId) other;

        return (this.getProductId() == castOther.getProductId()) && (this.getLocationId() == castOther.getLocationId());
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
        result = 37 * result + (locationId != null ? locationId : 0);
        return result;
    }

}
