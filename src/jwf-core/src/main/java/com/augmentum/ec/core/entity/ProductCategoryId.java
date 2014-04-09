/**
 * @author Adrian Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 8, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ProductCategoryId.
 */
@Embeddable
public final class ProductCategoryId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2123569027854245345L;

    /** The product id. */
    private Integer productId;

    /** The category id. */
    private Integer categoryId;

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

    /**
     * Gets the category id.
     * 
     * @return the category id
     */
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category id.
     * 
     * @param categoryId the new category id
     */
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

}
