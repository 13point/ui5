/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class ProductLocation.
 */
@Entity
@Table(name = "product_location", catalog = "ec_core")
public final class ProductLocation implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 812880401206161172L;

    /** The id. */
    private ProductLocationId id;

    /**
     * Instantiates a new product location.
     */
    public ProductLocation() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
        @AttributeOverride(name = "locationId", column = @Column(name = "location_id", nullable = false)) })
    public ProductLocationId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final ProductLocationId id) {
        this.id = id;
    }

}
