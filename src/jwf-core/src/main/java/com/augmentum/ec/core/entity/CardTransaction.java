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
 * The Class CardTransaction.
 */
@Entity
@Table(name = "card_transaction", catalog = "ec_core")
public final class CardTransaction implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6479922774460525358L;

    /** The transaction id. */
    private Long transactionId;

    /** The barcode id. */
    private Long barcodeId;

    /** The type. */
    private String type;

    /** The amount. */
    private BigDecimal amount;

    /** The balance. */
    private BigDecimal balance;

    /** The note. */
    private String note;

    /** The created. */
    private Date created;

    /**
     * Instantiates a new card transaction.
     */
    public CardTransaction() {
    }

    /**
     * Gets the transaction id.
     *
     * @return the transaction id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "transaction_id", unique = true, nullable = false)
    public Long getTransactionId() {
        return this.transactionId;
    }

    /**
     * Sets the transaction id.
     *
     * @param transactionId the new transaction id
     */
    public void setTransactionId(final Long transactionId) {
        this.transactionId = transactionId;
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
     * Gets the type.
     *
     * @return the type
     */
    @Column(name = "type", nullable = false, length = 9)
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(final String type) {
        this.type = type;
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
    @Column(name = "note", length = 45)
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
