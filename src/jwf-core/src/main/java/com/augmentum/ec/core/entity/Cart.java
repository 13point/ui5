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
 * The Class Cart.
 */
@Entity
@Table(name = "cart", catalog = "ec_core")
public final class Cart implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2533760474474120553L;

    /** The cart id. */
    private Long cartId;

    /** The is active. */
    private boolean isActive;

    /** The client ip. */
    private Integer clientIp;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /** The user id. */
    private Long userId;

    /**
     * Instantiates a new cart.
     */
    public Cart() {
    }

    /**
     * Gets the cart id.
     *
     * @return the cart id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cart_id", unique = true, nullable = false)
    public Long getCartId() {
        return this.cartId;
    }

    /**
     * Sets the cart id.
     *
     * @param cartId the new cart id
     */
    public void setCartId(final Long cartId) {
        this.cartId = cartId;
    }

    /**
     * Checks if is checks if is active.
     *
     * @return true, if is checks if is active
     */
    @Column(name = "is_active", nullable = false)
    public boolean isIsActive() {
        return this.isActive;
    }

    /**
     * Sets the checks if is active.
     *
     * @param isActive the new checks if is active
     */
    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
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

}
