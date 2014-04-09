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
 * The Class ProductSellStore.
 */
@Entity
@Table(name = "product_sell_store", catalog = "ec_core")
public final class ProductSellStore implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -701272421960123605L;

    /** The id. */
    private ProductSellStoreId id;

    /**
     * Instantiates a new product sell store.
     */
    public ProductSellStore() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
        @AttributeOverride(name = "storeId", column = @Column(name = "store_id", nullable = false)) })
    public ProductSellStoreId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final ProductSellStoreId id) {
        this.id = id;
    }

}
