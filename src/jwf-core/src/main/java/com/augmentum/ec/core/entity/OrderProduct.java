/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import java.math.BigDecimal;
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
 * The Class OrderProduct.
 */
@Entity
@Table(name = "order_product", catalog = "ec_core")
public final class OrderProduct implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2109607867354930477L;

    /** The id. */
    private OrderProductId id;

    /** The price. */
    private BigDecimal price;

    /** The face price. */
    private BigDecimal facePrice;

    /** The qty. */
    private Integer qty;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new order product.
     */
    public OrderProduct() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
        @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    public OrderProductId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final OrderProductId id) {
        this.id = id;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    @Column(name = "price", nullable = false, precision = 8)
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
    @Column(name = "face_price", nullable = false, precision = 8)
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
     * Gets the qty.
     *
     * @return the qty
     */
    @Column(name = "qty", nullable = false)
    public Integer getQty() {
        return this.qty;
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
