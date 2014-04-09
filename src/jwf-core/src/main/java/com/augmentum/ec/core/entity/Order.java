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
 * The Class Order.
 */
@Entity
@Table(name = "order", catalog = "ec_core")
public final class Order implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1275657998561649274L;

    /** The order id. */
    private Integer orderId;

    /** The user id. */
    private Long userId;

    /** The order status id. */
    private Integer orderStatusId;

    /** The subtotal. */
    private BigDecimal subtotal;

    /** The total qty. */
    private Integer totalQty;

    /** The email. */
    private String email;

    /** The mobile. */
    private String mobile;

    /** The note. */
    private String note;

    /** The client ip. */
    private Integer clientIp;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new order.
     */
    public Order() {
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * Sets the order id.
     *
     * @param orderId the new order id
     */
    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the order status id.
     *
     * @return the order status id
     */
    @Column(name = "order_status_id", nullable = false)
    public Integer getOrderStatusId() {
        return this.orderStatusId;
    }

    /**
     * Sets the order status id.
     *
     * @param orderStatusId the new order status id
     */
    public void setOrderStatusId(final Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    /**
     * Gets the subtotal.
     *
     * @return the subtotal
     */
    @Column(name = "subtotal", nullable = false, precision = 10)
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    /**
     * Sets the subtotal.
     *
     * @param subtotal the new subtotal
     */
    public void setSubtotal(final BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Gets the total qty.
     *
     * @return the total qty
     */
    @Column(name = "total_qty", nullable = false)
    public Integer getTotalQty() {
        return this.totalQty;
    }

    /**
     * Sets the total qty.
     *
     * @param totalQty the new total qty
     */
    public void setTotalQty(final Integer totalQty) {
        this.totalQty = totalQty;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the mobile.
     *
     * @return the mobile
     */
    @Column(name = "mobile", length = 11)
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile.
     *
     * @param mobile the new mobile
     */
    public void setMobile(final String mobile) {
        this.mobile = mobile;
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
     * Gets the client ip.
     *
     * @return the client ip
     */
    @Column(name = "client_ip", nullable = false)
    public Integer getClientIp() {
        return this.clientIp;
    }

    /**
     * Sets the client ip.
     *
     * @param clientIp the new client ip
     */
    public void setClientIp(final Integer clientIp) {
        this.clientIp = clientIp;
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
