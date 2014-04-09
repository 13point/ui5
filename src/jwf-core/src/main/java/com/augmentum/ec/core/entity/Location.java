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

/**
 * The Class Location.
 */
@Entity
@Table(name = "location", catalog = "ec_core")
public final class Location implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4812785560901780627L;

    /** The location id. */
    private Integer locationId;

    /** The parent id. */
    private Integer parentId;

    /** The name. */
    private String name;

    /** The level. */
    private Integer level;

    /** The is listed. */
    private boolean isListed;

    /** The pinyin. */
    private String pinyin;

    /** The lat. */
    private BigDecimal latitude;

    /** The long_. */
    private BigDecimal longitude;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new location.
     */
    public Location() {
    }

    /**
     * Gets the location id.
     *
     * @return the location id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "location_id", unique = true, nullable = false)
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
     * Gets the parent id.
     *
     * @return the parent id
     */
    @Column(name = "parent_id", nullable = false)
    public Integer getParentId() {
        return this.parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(final Integer parentId) {
        this.parentId = parentId;
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

    /**
     * Gets the level.
     *
     * @return the level
     */
    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return this.level;
    }

    /**
     * Sets the level.
     *
     * @param level the new level
     */
    public void setLevel(final Integer level) {
        this.level = level;
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
     * Gets the pinyin.
     *
     * @return the pinyin
     */
    @Column(name = "pinyin", nullable = false, length = 225)
    public String getPinyin() {
        return this.pinyin;
    }

    /**
     * Sets the pinyin.
     *
     * @param pinyin the new pinyin
     */
    public void setPinyin(final String pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * Gets the lat.
     *
     * @return the lat
     */
    @Column(name = "lat", precision = 10, scale = 6)
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
     * Gets the long_.
     *
     * @return the long_
     */
    @Column(name = "long", precision = 10, scale = 6)
    public BigDecimal getLongitude() {
        return this.longitude;
    }

    /**
     * Sets the long_.
     *
     * @param longitude the longitude
     */
    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude;
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
