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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class OrderPayment.
 */
@Entity
@Table(name = "order_payment", catalog = "ec_core")
public final class OrderPayment implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2609893602329634138L;

    /** The order id. */
    private Integer orderId;

    /** The payment method id. */
    private Integer paymentMethodId;

    /** The amount. */
    private BigDecimal amount;

    /** The is confirmed. */
    private boolean isConfirmed;

    /** The memo. */
    private String memo;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new order payment.
     */
    public OrderPayment() {
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    @Id
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
     * Gets the payment method id.
     *
     * @return the payment method id
     */
    @Column(name = "payment_method_id", nullable = false)
    public Integer getPaymentMethodId() {
        return this.paymentMethodId;
    }

    /**
     * Sets the payment method id.
     *
     * @param paymentMethodId the new payment method id
     */
    public void setPaymentMethodId(final Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    @Column(name = "amount", nullable = false, precision = 10)
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Checks if is checks if is confirmed.
     *
     * @return true, if is checks if is confirmed
     */
    @Column(name = "is_confirmed", nullable = false)
    public boolean isIsConfirmed() {
        return this.isConfirmed;
    }

    /**
     * Sets the checks if is confirmed.
     *
     * @param isConfirmed the new checks if is confirmed
     */
    public void setIsConfirmed(final boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    /**
     * Gets the memo.
     *
     * @return the memo
     */
    @Column(name = "memo", length = 65535)
    public String getMemo() {
        return this.memo;
    }

    /**
     * Sets the memo.
     *
     * @param memo the new memo
     */
    public void setMemo(final String memo) {
        this.memo = memo;
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
