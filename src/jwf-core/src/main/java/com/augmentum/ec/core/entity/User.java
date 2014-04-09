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
 * The Class User.
 */
@Entity
@Table(name = "user", catalog = "ec_core")
public final class User implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6718859190782978249L;

    /** The user id. */
    private Long userId;

    /** The user type id. */
    private Integer userTypeId;

    /** The status. */
    private String status;

    /** The email. */
    private String email;

    /** The mobile. */
    private String mobile;

    /** The name. */
    private String name;

    /** The password. */
    private String password;

    /** The consumption pwd. */
    private Integer consumptionPwd;

    /** The slat. */
    private String slat;

    /** The fullname. */
    private String fullname;

    /** The account balance. */
    private BigDecimal accountBalance;

    /** The is email verified. */
    private boolean isEmailVerified;

    /** The is mobile verified. */
    private boolean isMobileVerified;

    /** The client ip. */
    private Integer clientIp;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /** The last login. */
    private Date lastLogin;

    /** The last ip. */
    private Integer lastIp;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
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
     * Gets the user type id.
     *
     * @return the user type id
     */
    @Column(name = "user_type_id", nullable = false)
    public Integer getUserTypeId() {
        return this.userTypeId;
    }

    /**
     * Sets the user type id.
     *
     * @param userTypeId the new user type id
     */
    public void setUserTypeId(final Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    @Column(name = "status", nullable = false, length = 7)
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(final String status) {
        this.status = status;
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
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name", length = 64)
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the consumption pwd.
     *
     * @return the consumption pwd
     */
    @Column(name = "consumption_pwd")
    public Integer getConsumptionPwd() {
        return this.consumptionPwd;
    }

    /**
     * Sets the consumption pwd.
     *
     * @param consumptionPwd the new consumption pwd
     */
    public void setConsumptionPwd(final Integer consumptionPwd) {
        this.consumptionPwd = consumptionPwd;
    }

    /**
     * Gets the slat.
     *
     * @return the slat
     */
    @Column(name = "slat", nullable = false, length = 6)
    public String getSlat() {
        return this.slat;
    }

    /**
     * Sets the slat.
     *
     * @param slat the new slat
     */
    public void setSlat(final String slat) {
        this.slat = slat;
    }

    /**
     * Gets the fullname.
     *
     * @return the fullname
     */
    @Column(name = "fullname", length = 64)
    public String getFullname() {
        return this.fullname;
    }

    /**
     * Sets the fullname.
     *
     * @param fullname the new fullname
     */
    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets the account balance.
     *
     * @return the account balance
     */
    @Column(name = "account_balance", nullable = false, precision = 10)
    public BigDecimal getAccountBalance() {
        return this.accountBalance;
    }

    /**
     * Sets the account balance.
     *
     * @param accountBalance the new account balance
     */
    public void setAccountBalance(final BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Checks if is checks if is email verified.
     *
     * @return true, if is checks if is email verified
     */
    @Column(name = "is_email_verified", nullable = false)
    public boolean isIsEmailVerified() {
        return this.isEmailVerified;
    }

    /**
     * Sets the checks if is email verified.
     *
     * @param isEmailVerified the new checks if is email verified
     */
    public void setIsEmailVerified(final boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    /**
     * Checks if is checks if is mobile verified.
     *
     * @return true, if is checks if is mobile verified
     */
    @Column(name = "is_mobile_verified", nullable = false)
    public boolean isIsMobileVerified() {
        return this.isMobileVerified;
    }

    /**
     * Sets the checks if is mobile verified.
     *
     * @param isMobileVerified the new checks if is mobile verified
     */
    public void setIsMobileVerified(final boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
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

    /**
     * Gets the last login.
     *
     * @return the last login
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", length = 19)
    public Date getLastLogin() {
        return this.lastLogin;
    }

    /**
     * Sets the last login.
     *
     * @param lastLogin the new last login
     */
    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Gets the last ip.
     *
     * @return the last ip
     */
    @Column(name = "last_ip")
    public Integer getLastIp() {
        return this.lastIp;
    }

    /**
     * Sets the last ip.
     *
     * @param lastIp the new last ip
     */
    public void setLastIp(final Integer lastIp) {
        this.lastIp = lastIp;
    }

}
