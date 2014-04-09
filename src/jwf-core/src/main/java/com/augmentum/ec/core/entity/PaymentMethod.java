/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class PaymentMethod.
 */
@Entity
@Table(name = "payment_method", catalog = "ec_core")
public final class PaymentMethod implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5918323144250965606L;

    /** The payment method id. */
    private Integer paymentMethodId;

    /** The name. */
    private String name;

    /** The alias. */
    private String alias;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /** The status. */
    private Integer status;

    /**
     * Instantiates a new payment method.
     */
    public PaymentMethod() {
    }

    /**
     * Gets the payment method id.
     *
     * @return the payment method id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "payment_method_id", unique = true, nullable = false)
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
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 64)
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
     * Gets the alias.
     *
     * @return the alias
     */
    @Column(name = "alias", nullable = false, length = 45)
    public String getAlias() {
        return this.alias;
    }

    /**
     * Sets the alias.
     *
     * @param alias the new alias
     */
    public void setAlias(final String alias) {
        this.alias = alias;
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
     * Gets the icon.
     *
     * @return the icon
     */
    @Column(name = "icon")
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
     * Gets the status.
     *
     * @return the status
     */
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

}
