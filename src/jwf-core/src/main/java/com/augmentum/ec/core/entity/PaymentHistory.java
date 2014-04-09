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
 * The Class PaymentHistory.
 */
@Entity
@Table(name = "payment_history", catalog = "ec_core")
public final class PaymentHistory implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7680070849551897012L;

    /** The payment history id. */
    private Long paymentHistoryId;

    /** The user id. */
    private Long userId;

    /** The order id. */
    private Integer orderId;

    /** The payment method id. */
    private Integer paymentMethodId;

    /** The memo. */
    private String memo;

    /** The created. */
    private Date created;

    /**
     * Instantiates a new payment history.
     */
    public PaymentHistory() {
    }

    /**
     * Gets the payment history id.
     *
     * @return the payment history id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "payment_history_id", unique = true, nullable = false)
    public Long getPaymentHistoryId() {
        return this.paymentHistoryId;
    }

    /**
     * Sets the payment history id.
     *
     * @param paymentHistoryId the new payment history id
     */
    public void setPaymentHistoryId(final Long paymentHistoryId) {
        this.paymentHistoryId = paymentHistoryId;
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
     * Gets the order id.
     *
     * @return the order id
     */
    @Column(name = "order_id", nullable = false)
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
    @Column(name = "created", nullable = false, length = 19)
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
