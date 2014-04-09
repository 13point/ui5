/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Brand.
 */
@Entity
@Table(name = "brand", catalog = "ec_core")
@NamedQueries({ @NamedQuery(name = "Brand.getByBrandIds", query = "FROM Brand b WHERE b.brandId IN :brandIds") })
public final class Brand implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8819260202639372759L;

    /** The brand id. */
    private Integer brandId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new brand.
     */
    public Brand() {
    }

    /**
     * Gets the brand id.
     * 
     * @return the brand id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    public Integer getBrandId() {
        return this.brandId;
    }

    /**
     * Sets the brand id.
     * 
     * @param brandId the new brand id
     */
    public void setBrandId(final Integer brandId) {
        this.brandId = brandId;
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
     * Gets the description.
     * 
     * @return the description
     */
    @Column(name = "description", length = 65535)
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
     * Gets the icon.
     * 
     * @return the icon
     */
    @Column(name = "icon")
    public String getIcon() {
        return this.icon;
    }

    /**
     * Sets the icon.
     * 
     * @param icon the new icon
     */
    public void setIcon(final String icon) {
        this.icon = icon;
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
