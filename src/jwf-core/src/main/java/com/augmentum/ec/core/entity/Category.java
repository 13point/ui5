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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Category.
 */
@Entity
@Table(name = "category", catalog = "ec_core")
public final class Category implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8237171669875328750L;

    /** The category id. */
    private Integer categoryId;

    /** The parent id. */
    private Integer parentId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /** The position. */
    private Integer position;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new category.
     */
    public Category() {
    }

    /**
     * Gets the category id.
     *
     * @return the category id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    public Integer getCategoryId() {
        return this.categoryId;
    }

    /**
     * Sets the category id.
     *
     * @param categoryId the new category id
     */
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
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
     * Gets the position.
     *
     * @return the position
     */
    @Column(name = "position", nullable = false)
    public Integer getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(final Integer position) {
        this.position = position;
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
