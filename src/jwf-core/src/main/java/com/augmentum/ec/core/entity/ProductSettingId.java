/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ProductSettingId.
 */
@Embeddable
public final class ProductSettingId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4099199795178573538L;

    /** The product id. */
    private Integer productId;

    /** The path. */
    private String path;

    /** The product setting group id. */
    private int productSettingGroupId;

    /**
     * Instantiates a new product setting id.
     */
    public ProductSettingId() {
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
     * Gets the path.
     *
     * @return the path
     */
    @Column(name = "path", nullable = false)
    public String getPath() {
        return this.path;
    }

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Gets the product setting group id.
     *
     * @return the product setting group id
     */
    @Column(name = "product_setting_group_id", nullable = false)
    public int getProductSettingGroupId() {
        return this.productSettingGroupId;
    }

    /**
     * Sets the product setting group id.
     *
     * @param productSettingGroupId the new product setting group id
     */
    public void setProductSettingGroupId(final int productSettingGroupId) {
        this.productSettingGroupId = productSettingGroupId;
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
        if (!(other instanceof ProductSettingId)) {
            return false;
        }
        ProductSettingId castOther = (ProductSettingId) other;

        return (this.getProductId() == castOther.getProductId())
                && ((this.getPath() == castOther.getPath())
                        || (this.getPath() != null && castOther.getPath() != null
                        && this.getPath().equals(castOther.getPath())))
                && (this.getProductSettingGroupId() == castOther.getProductSettingGroupId());
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
        result = 37 * result + (getPath() == null ? 0 : this.getPath().hashCode());
        result = 37 * result + this.getProductSettingGroupId();
        return result;
    }

}
