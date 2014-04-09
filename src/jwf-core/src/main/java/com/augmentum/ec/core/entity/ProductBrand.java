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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class ProductBrand.
 */
@Entity
@Table(name = "product_brand", catalog = "ec_core")
@NamedQueries({ @NamedQuery(name = "ProductBrand.getByProductIds",
        query = "FROM ProductBrand pb WHERE pb.id.productId IN :productIds") })
public final class ProductBrand implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -597305978371024350L;

    /** The id. */
    private ProductBrandId id;

    /**
     * Instantiates a new product brand.
     */
    public ProductBrand() {
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
        @AttributeOverride(name = "brandId", column = @Column(name = "brand_id", nullable = false)) })
    public ProductBrandId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     * 
     * @param id the new id
     */
    public void setId(final ProductBrandId id) {
        this.id = id;
    }

}
