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
 * The Class Merchant.
 */
@Entity
@Table(name = "merchant", catalog = "ec_core")
public final class Merchant implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3998986934039846622L;

    /** The merchant id. */
    private Integer merchantId;

    /** The merchant name. */
    private String merchantName;

    /** The email. */
    private String email;

    /** The status. */
    private boolean status;

    /** The app key. */
    private String appKey;

    /** The icon. */
    private String icon;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new merchant.
     */
    public Merchant() {
    }

    /**
     * Gets the merchant id.
     *
     * @return the merchant id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "merchant_id", unique = true, nullable = false)
    public Integer getMerchantId() {
        return this.merchantId;
    }

    /**
     * Sets the merchant id.
     *
     * @param merchantId the new merchant id
     */
    public void setMerchantId(final Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Gets the merchant name.
     *
     * @return the merchant name
     */
    @Column(name = "merchant_name", nullable = false, length = 128)
    public String getMerchantName() {
        return this.merchantName;
    }

    /**
     * Sets the merchant name.
     *
     * @param merchantName the new merchant name
     */
    public void setMerchantName(final String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    @Column(name = "email", nullable = false, length = 128)
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
     * Checks if is status.
     *
     * @return true, if is status
     */
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(final boolean status) {
        this.status = status;
    }

    /**
     * Gets the app key.
     *
     * @return the app key
     */
    @Column(name = "app_key", length = 45)
    public String getAppKey() {
        return this.appKey;
    }

    /**
     * Sets the app key.
     *
     * @param appKey the new app key
     */
    public void setAppKey(final String appKey) {
        this.appKey = appKey;
    }

    /**
     * Gets the icon.
     *
     * @return the icon
     */
    @Column(name = "icon", length = 128)
    public String getIcon() {
        return this.icon;
    }

    /**
     * Sets the icon.
     *
     * @param icon the new icon
     */
    public void setIcon(final String icon) {
        this.icon = icon;
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
