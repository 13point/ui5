/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 8, 2014
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
 * The Class ProductCategory.
 */
@Entity
@Table(name = "product_category", catalog = "ec_core")
@NamedQueries({ @NamedQuery(name = "ProductCategory.getByProductIds",
        query = "FROM ProductCategory pc WHERE pc.id.productId IN :productIds") })
public final class ProductCategory implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4428052087747517873L;

    /** The id. */
    private ProductCategoryId id;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
        @AttributeOverride(name = "categoryId", column = @Column(name = "category_id", nullable = false)) })
    public ProductCategoryId getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id the new id
     */
    public void setId(final ProductCategoryId id) {
        this.id = id;
    }

}
