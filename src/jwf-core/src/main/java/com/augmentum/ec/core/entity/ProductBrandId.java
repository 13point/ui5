/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ProductBrandId.
 */
@Embeddable
public final class ProductBrandId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3009169196423295984L;

    /** The product id. */
    private Integer productId;

    /** The brand id. */
    private Integer brandId;

    /**
     * Instantiates a new product brand id.
     */
    public ProductBrandId() {
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
     * Gets the brand id.
     *
     * @return the brand id
     */
    @Column(name = "brand_id", nullable = false)
    public Integer getBrandId() {
        return this.brandId;
    }

    /**
     * Sets the brand id.
     *
     * @param brandId the new brand id
     */
    public void setBrandId(final Integer brandId) {
        this.brandId = brandId;
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
        if (!(other instanceof ProductBrandId)) {
            return false;
        }
        ProductBrandId castOther = (ProductBrandId) other;

        return (this.getProductId() == castOther.getProductId()) && (this.getBrandId() == castOther.getBrandId());
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
        result = 37 * result + (brandId != null ? productId : 0);
        return result;
    }

}
