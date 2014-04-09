/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class UserProduct.
 */
@Entity
@Table(name = "user_product", catalog = "ec_core")
public final class UserProduct implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8661885251895267730L;

    /** The id. */
    private UserProductId id;

    /** The product type id. */
    private Integer productTypeId;

    /** The is deleted. */
    private boolean isDeleted;

    /** The note. */
    private String note;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new user product.
     */
    public UserProduct() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    public UserProductId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final UserProductId id) {
        this.id = id;
    }

    /**
     * Gets the product type id.
     *
     * @return the product type id
     */
    @Column(name = "product_type_id", nullable = false)
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
     * Checks if is checks if is deleted.
     *
     * @return true, if is checks if is deleted
     */
    @Column(name = "is_deleted", nullable = false)
    public boolean isIsDeleted() {
        return this.isDeleted;
    }

    /**
     * Sets the checks if is deleted.
     *
     * @param isDeleted the new checks if is deleted
     */
    public void setIsDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * Gets the note.
     *
     * @return the note
     */
    @Column(name = "note")
    public String getNote() {
        return this.note;
    }

    /**
     * Sets the note.
     *
     * @param note the new note
     */
    public void setNote(final String note) {
        this.note = note;
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
