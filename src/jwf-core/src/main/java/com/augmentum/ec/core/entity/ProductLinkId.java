package com.augmentum.ec.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductLinkId.
 */
@Embeddable
public final class ProductLinkId implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The product id. */
    private Integer productId;

    /** The linked product id. */
    private Integer linkedProductId;

    /** The type. */
    private String type;

    /**
     * Instantiates a new product link id.
     */
    public ProductLinkId() {
    }

    /**
     * Gets the linked product id.
     * 
     * @return the linked product id
     */
    @Column(name = "linked_product_id", nullable = false)
    public Integer getLinkedProductId() {
        return linkedProductId;
    }

    /**
     * Sets the linked product id.
     * 
     * @param linkedProductId the new linked product id
     */
    public void setLinkedProductId(final Integer linkedProductId) {
        this.linkedProductId = linkedProductId;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * 
     * @param type the new type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets the product id.
     * 
     * @return the product id
     */
    @Column(name = "product_id", nullable = false)
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
        if (!(other instanceof ProductLinkId)) {
            return false;
        }
        ProductLinkId castOther = (ProductLinkId) other;

        return (this.getProductId() == castOther.getProductId())
                && (this.getLinkedProductId() == castOther.getLinkedProductId() && (this.getType().equals(castOther
                        .getType())));
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
        result = 37 * result + (linkedProductId != null ? linkedProductId : 0);
        return result;
    }

}
