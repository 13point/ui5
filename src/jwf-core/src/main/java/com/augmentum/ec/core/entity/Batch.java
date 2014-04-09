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
 * The Class Batch.
 */
@Entity
@Table(name = "batch", catalog = "ec_core")
public final class Batch implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9031952962756226014L;

    /** The batch id. */
    private Integer batchId;

    /** The product id. */
    private Integer productId;

    /** The price. */
    private BigDecimal price;

    /** The face price. */
    private BigDecimal facePrice;

    /** The exp datetime. */
    private Date expDatetime;

    /** The description. */
    private String description;

    /** The quantity. */
    private Integer quantity;

    /** The created. */
    private Date created;

    /**
     * Instantiates a new batch.
     */
    public Batch() {
    }

    /**
     * Gets the batch id.
     *
     * @return the batch id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "batch_id", unique = true, nullable = false)
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
     * Gets the product id.
     *
     * @return the product id
     */
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return this.productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId the new product id
     */
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    @Column(name = "price", precision = 8)
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the face price.
     *
     * @return the face price
     */
    @Column(name = "face_price", precision = 8)
    public BigDecimal getFacePrice() {
        return this.facePrice;
    }

    /**
     * Sets the face price.
     *
     * @param facePrice the new face price
     */
    public void setFacePrice(final BigDecimal facePrice) {
        this.facePrice = facePrice;
    }

    /**
     * Gets the exp datetime.
     *
     * @return the exp datetime
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exp_datetime", length = 19)
    public Date getExpDatetime() {
        return this.expDatetime;
    }

    /**
     * Sets the exp datetime.
     *
     * @param expDatetime the new exp datetime
     */
    public void setExpDatetime(final Date expDatetime) {
        this.expDatetime = expDatetime;
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
     * Gets the quantity.
     *
     * @return the quantity
     */
    @Column(name = "quantity")
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
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

}
