/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ProductType.
 */
@Entity
@Table(name = "product_type", catalog = "ec_core")
public final class ProductType implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4817213191723545384L;

    /** The product type id. */
    private Integer productTypeId;

    /** The name. */
    private String name;

    /**
     * Instantiates a new product type.
     */
    public ProductType() {
    }

    /**
     * Gets the product type id.
     *
     * @return the product type id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_type_id", unique = true, nullable = false)
    public Integer getProductTypeId() {
        return this.productTypeId;
    }

    /**
     * Sets the product type id.
     *
     * @param productTypeId the new product type id
     */
    public void setProductTypeId(final Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

}
