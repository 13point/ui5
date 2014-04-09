/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

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
 * The Class BarcodeBatch.
 */
@Entity
@Table(name = "barcode_batch", catalog = "ec_core")
public final class BarcodeBatch implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6288784171833185572L;

    /** The id. */
    private Long id;

    /** The batch id. */
    private Integer batchId;

    /** The barcode id. */
    private Long barcodeId;

    /** The barcode. */
    private String barcode;

    /** The numcode. */
    private String numcode;

    /** The is valid. */
    private boolean isValid;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new barcode batch.
     */
    public BarcodeBatch() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the batch id.
     *
     * @return the batch id
     */
    @Column(name = "batch_id", nullable = false)
    public Integer getBatchId() {
        return this.batchId;
    }

    /**
     * Sets the batch id.
     *
     * @param batchId the new batch id
     */
    public void setBatchId(final Integer batchId) {
        this.batchId = batchId;
    }

    /**
     * Gets the barcode id.
     *
     * @return the barcode id
     */
    @Column(name = "barcode_id", nullable = false)
    public Long getBarcodeId() {
        return this.barcodeId;
    }

    /**
     * Sets the barcode id.
     *
     * @param barcodeId the new barcode id
     */
    public void setBarcodeId(final Long barcodeId) {
        this.barcodeId = barcodeId;
    }

    /**
     * Gets the barcode.
     *
     * @return the barcode
     */
    @Column(name = "barcode", nullable = false, length = 32)
    public String getBarcode() {
        return this.barcode;
    }

    /**
     * Sets the barcode.
     *
     * @param barcode the new barcode
     */
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }

    /**
     * Gets the numcode.
     *
     * @return the numcode
     */
    @Column(name = "numcode", nullable = false, length = 16)
    public String getNumcode() {
        return this.numcode;
    }

    /**
     * Sets the numcode.
     *
     * @param numcode the new numcode
     */
    public void setNumcode(final String numcode) {
        this.numcode = numcode;
    }

    /**
     * Checks if is checks if is valid.
     *
     * @return true, if is checks if is valid
     */
    @Column(name = "is_valid", nullable = false)
    public boolean isIsValid() {
        return this.isValid;
    }

    /**
     * Sets the checks if is valid.
     *
     * @param isValid the new checks if is valid
     */
    public void setIsValid(final boolean isValid) {
        this.isValid = isValid;
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
