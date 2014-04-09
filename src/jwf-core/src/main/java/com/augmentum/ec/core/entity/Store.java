/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class Store.
 */
@Entity
@Table(name = "store", catalog = "ec_core")
public final class Store implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 188475931547188905L;

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

    /** The long_. */
    private BigDecimal longitude;

    /** The lat. */
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
     * Instantiates a new store.
     */
    public Store() {
    }

    /**
     * Gets the store id.
     * 
     * @return the store id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "store_id", unique = true, nullable = false)
    public Integer getStoreId() {
        return this.storeId;
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
    @Column(name = "department_id", nullable = false)
    public Integer getDepartmentId() {
        return this.departmentId;
    }

    /**
     * Sets the department id.
     * 
     * @param departmentId the new merchant id
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 45)
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

    /**
     * Gets the description.
     * 
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return this.description;
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
    @Column(name = "phone", length = 20)
    public String getPhone() {
        return this.phone;
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
     * Gets the address.
     * 
     * @return the address
     */
    @Column(name = "address")
    public String getAddress() {
        return this.address;
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
     * Gets the location id.
     * 
     * @return the location id
     */
    @Column(name = "location_id", nullable = false)
    public Integer getLocationId() {
        return this.locationId;
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
     * Gets the long_.
     * 
     * @return the long_
     */
    @Column(name = "long", nullable = false, precision = 10, scale = 6)
    public BigDecimal getLongitude() {
        return this.longitude;
    }

    /**
     * Sets the long_.
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
    @Column(name = "lat", nullable = false, precision = 10, scale = 6)
    public BigDecimal getLatitude() {
        return this.latitude;
    }

    /**
     * Sets the lat.
     * 
     * @param latitude the new latitude
     */
    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * Checks if is checks if is listed.
     * 
     * @return true, if is checks if is listed
     */
    @Column(name = "is_listed", nullable = false)
    public boolean isIsListed() {
        return this.isListed;
    }


    /**
     * Sets the checks if is listed.
     * 
     * @param isListed the new checks if is listed
     */
    public void setIsListed(final boolean isListed) {
        this.isListed = isListed;
    }

    /**
     * Gets the can sell.
     * 
     * @return the can sell
     */
    @Column(name = "can_sell", nullable = false)
    public Integer getCanSell() {
        return this.canSell;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    public Date getCreated() {
        return this.created;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", length = 19)
    public Date getUpdated() {
        return this.updated;
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
