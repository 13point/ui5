/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Barcode.
 */
@Entity
@Table(name = "barcode", catalog = "ec_core")
public final class Barcode implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4862714996728800987L;

    /** The barcode id. */
    private Long barcodeId;

    /** The barcode. */
    private String barcode;

    /** The numcode. */
    private String numcode;

    /** The barcode type. */
    private String barcodeType;

    /** The product id. */
    private Integer productId;

    /** The price. */
    private BigDecimal price;

    /** The face price. */
    private BigDecimal facePrice;

    /** The exp datetime. */
    private Date expDatetime;

    /** The is used. */
    private boolean isUsed;

    /** The is sent. */
    private boolean isSent;

    /** The order id. */
    private Integer orderId;

    /** The user id. */
    private Long userId;

    /** The parent id. */
    private Long parentId;

    /** The email. */
    private String email;

    /** The mobile. */
    private String mobile;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /** The is acked. */
    private boolean isAcked;

    /**
     * Instantiates a new barcode.
     */
    public Barcode() {
    }

    /**
     * Gets the barcode id.
     *
     * @return the barcode id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "barcode_id", unique = true, nullable = false)
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
     * Gets the barcode type.
     *
     * @return the barcode type
     */
    @Column(name = "barcode_type", nullable = false, length = 11)
    public String getBarcodeType() {
        return this.barcodeType;
    }

    /**
     * Sets the barcode type.
     *
     * @param barcodeType the new barcode type
     */
    public void setBarcodeType(final String barcodeType) {
        this.barcodeType = barcodeType;
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
     * Gets the exp datetime.
     *
     * @return the exp datetime
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exp_datetime", nullable = false, length = 19)
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
     * Checks if is checks if is used.
     *
     * @return true, if is checks if is used
     */
    @Column(name = "is_used", nullable = false)
    public boolean isIsUsed() {
        return this.isUsed;
    }

    /**
     * Sets the checks if is used.
     *
     * @param isUsed the new checks if is used
     */
    public void setIsUsed(final boolean isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * Checks if is checks if is sent.
     *
     * @return true, if is checks if is sent
     */
    @Column(name = "is_sent", nullable = false)
    public boolean isIsSent() {
        return this.isSent;
    }

    /**
     * Sets the checks if is sent.
     *
     * @param isSent the new checks if is sent
     */
    public void setIsSent(final boolean isSent) {
        this.isSent = isSent;
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
     * Gets the parent id.
     *
     * @return the parent id
     */
    @Column(name = "parent_id", nullable = false)
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public  void setParentId(final Long parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    @Column(name = "email")
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

    /**
     * Checks if is checks if is acked.
     *
     * @return true, if is checks if is acked
     */
    @Column(name = "is_acked", nullable = false)
    public boolean isIsAcked() {
        return this.isAcked;
    }

    /**
     * Sets the checks if is acked.
     *
     * @param isAcked the new checks if is acked
     */
    public void setIsAcked(final boolean isAcked) {
        this.isAcked = isAcked;
    }

}
