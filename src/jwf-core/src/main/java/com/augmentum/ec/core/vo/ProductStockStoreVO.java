package com.augmentum.ec.core.vo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductStockStoreVO.
 */
public final class ProductStockStoreVO implements Serializable {

    /** The store id. */
    private Integer storeId;

    /** The name. */
    private String name;

    /** The qty available. */
    private Integer qtyAvailable;

    /**
     * Gets the store id.
     * 
     * @return the store id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * Sets the store id.
     * 
     * @param storeId the new store id
     */
    public void setStoreId(final Integer storeId) {
        this.storeId = storeId;
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

}
