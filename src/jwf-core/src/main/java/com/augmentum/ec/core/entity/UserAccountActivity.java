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
 * The Class UserAccountActivity.
 */
@Entity
@Table(name = "user_account_activity", catalog = "ec_core")
public final class UserAccountActivity implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9176941406222055872L;

    /** The user account activity id. */
    private Long userAccountActivityId;

    /** The user id. */
    private Long userId;

    /** The activity type. */
    private String activityType;

    /** The amount. */
    private BigDecimal amount;

    /** The balance. */
    private BigDecimal balance;

    /** The note. */
    private String note;

    /** The created. */
    private Date created;

    /**
     * Instantiates a new user account activity.
     */
    public UserAccountActivity() {
    }

    /**
     * Gets the user account activity id.
     *
     * @return the user account activity id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_account_activity_id", unique = true, nullable = false)
    public Long getUserAccountActivityId() {
        return this.userAccountActivityId;
    }

    /**
     * Sets the user account activity id.
     *
     * @param userAccountActivityId the new user account activity id
     */
    public void setUserAccountActivityId(final Long userAccountActivityId) {
        this.userAccountActivityId = userAccountActivityId;
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
     * Gets the activity type.
     *
     * @return the activity type
     */
    @Column(name = "activity_type", nullable = false, length = 8)
    public String getActivityType() {
        return this.activityType;
    }

    /**
     * Sets the activity type.
     *
     * @param activityType the new activity type
     */
    public void setActivityType(final String activityType) {
        this.activityType = activityType;
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
     * Gets the balance.
     *
     * @return the balance
     */
    @Column(name = "balance", nullable = false, precision = 10)
    public BigDecimal getBalance() {
        return this.balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
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
