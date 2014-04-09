/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class PaymentMethodSettingId.
 */
@Embeddable
public final class PaymentMethodSettingId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7603749799227115659L;

    /** The payment method id. */
    private Integer paymentMethodId;

    /** The path. */
    private String path;

    /**
     * Instantiates a new payment method setting id.
     */
    public PaymentMethodSettingId() {
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
     * Gets the path.
     *
     * @return the path
     */
    @Column(name = "path", nullable = false)
    public String getPath() {
        return this.path;
    }

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof PaymentMethodSettingId)) {
            return false;
        }
        PaymentMethodSettingId castOther = (PaymentMethodSettingId) other;

        return (this.getPaymentMethodId() == castOther.getPaymentMethodId())
                && ((this.getPath() == castOther.getPath())
                        || (this.getPath() != null
                        && castOther.getPath() != null
                        && this.getPath().equals(castOther.getPath())));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (paymentMethodId != null ? paymentMethodId : 0);
        result = 37 * result + (getPath() == null ? 0 : this.getPath().hashCode());
        return result;
    }

}
