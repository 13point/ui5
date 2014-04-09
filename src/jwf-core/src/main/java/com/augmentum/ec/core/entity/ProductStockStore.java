package com.augmentum.ec.core.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductStockStore.
 */
@Entity
@Table(name = "product_stock_store", catalog = "ec_core")
public final class ProductStockStore implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private ProductStoreId id;

    /** The qty. */
    private Integer qty;

    /** The qty available. */
    private Integer qtyAvailable;

    /** The qty pending. */
    private Integer qtyPending;

    /** The qty sold. */
    private Integer qtySold;

    /** The created. */
    private String created;

    /** The name. */
    private String name;

    /**
     * Instantiates a new product stock store.
     */
    public ProductStockStore() {
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
    public ProductStoreId getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id the new id
     */
    public void setId(final ProductStoreId id) {
        this.id = id;
    }

    /**
     * Gets the qty.
     * 
     * @return the qty
     */
    @Column(name = "qty")
    public Integer getQty() {
        return qty;
    }

    /**
     * Sets the qty.
     * 
     * @param qty the new qty
     */
    public void setQty(final Integer qty) {
        this.qty = qty;
    }


    /**
     * Gets the created.
     * 
     * @return the created
     */
    @Column(name = "created")
    public String getCreated() {
        return created;
    }

    /**
     * Sets the created.
     * 
     * @param created the new created
     */
    public void setCreated(final String created) {
        this.created = created;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the qty available.
     * 
     * @return the qty available
     */
    @Column(name = "qty_available")
    public Integer getQtyAvailable() {
        return qtyAvailable;
    }

    /**
     * Sets the qty available.
     * 
     * @param qtyAvailable the new qty available
     */
    public void setQtyAvailable(final Integer qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    /**
     * Gets the qty pending.
     * 
     * @return the qty pending
     */
    @Column(name = "qty_pending")
    public Integer getQtyPending() {
        return qtyPending;
    }

    /**
     * Sets the qty pending.
     * 
     * @param qtyPending the new qty pending
     */
    public void setQtyPending(final Integer qtyPending) {
        this.qtyPending = qtyPending;
    }

    /**
     * Gets the qty sold.
     * 
     * @return the qty sold
     */
    @Column(name = "qty_sold")
    public Integer getQtySold() {
        return qtySold;
    }

    /**
     * Sets the qty sold.
     * 
     * @param qtySold the new qty sold
     */
    public void setQtySold(final Integer qtySold) {
        this.qtySold = qtySold;
    }

}
