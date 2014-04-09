package com.augmentum.ec.core.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductLink.
 */
@Entity
@Table(name = "product_link", catalog = "ec_core")
public final class ProductLink implements java.io.Serializable {

    /** The id. */
    private ProductLinkId id;

    /** The product. */
    private Product product;

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productId", 
                    column = @Column(name = "product_id", nullable = false)),
            @AttributeOverride(name = "linkedProductId", 
                    column = @Column(name = "linked_product_id", nullable = false)),
            @AttributeOverride(name = "type", column = @Column(name = "type", nullable = false)) })
    public ProductLinkId getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final ProductLinkId id) {
        this.id = id;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param product the new product
     */
    public void setProduct(final Product product) {
        this.product = product;
    }

}
