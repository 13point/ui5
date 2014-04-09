/**
 * @author Charles xu <charlesxu@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Apr 3, 2014
 */
package com.augmentum.ec.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreVO.
 */
public final class StoreVO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7075083359014349315L;

    /** The store id. */
    private Integer storeId;

    /** The department id. */
    private Integer departmentId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The phone. */
    private String phone;

    /** The location id. */
    private Integer locationId;

    /** The address. */
    private String address;

    /** The longitude. */
    private BigDecimal longitude;

    /** The latitude. */
    private BigDecimal latitude;

    /** The is listed. */
    private boolean isListed;

    /** The can sell. */
    private Integer canSell;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

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
     * Gets the department id.
     * 
     * @return the department id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department id.
     * 
     * @param departmentId the new department id
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
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
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the phone.
     * 
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     * 
     * @param phone the new phone
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Gets the location id.
     * 
     * @return the location id
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * Sets the location id.
     * 
     * @param locationId the new location id
     */
    public void setLocationId(final Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address the new address
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     * 
     * @param longitude the new longitude
     */
    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     * 
     * @param latitude the new latitude
     */
    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * Checks if is listed.
     * 
     * @return true, if is listed
     */
    public boolean isListed() {
        return isListed;
    }

    /**
     * Sets the listed.
     * 
     * @param isListed the new listed
     */
    public void setListed(final boolean isListed) {
        this.isListed = isListed;
    }

    /**
     * Gets the can sell.
     * 
     * @return the can sell
     */
    public Integer getCanSell() {
        return canSell;
    }

    /**
     * Sets the can sell.
     * 
     * @param canSell the new can sell
     */
    public void setCanSell(final Integer canSell) {
        this.canSell = canSell;
    }

    /**
     * Gets the created.
     * 
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the created.
     * 
     * @param created the new created
     */
    public void setCreated(final Date created) {
        this.created = created;
    }

    /**
     * Gets the updated.
     * 
     * @return the updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the updated.
     * 
     * @param updated the new updated
     */
    public void setUpdated(final Date updated) {
        this.updated = updated;
    }
}
