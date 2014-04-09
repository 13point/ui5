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
 * The Class OrderStatus.
 */
@Entity
@Table(name = "order_status", catalog = "ec_core")
public final class OrderStatus implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6621479458488348478L;

    /** The order status id. */
    private Integer orderStatusId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /**
     * Instantiates a new order status.
     */
    public OrderStatus() {
    }

    /**
     * Gets the order status id.
     *
     * @return the order status id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_status_id", unique = true, nullable = false)
    public Integer getOrderStatusId() {
        return this.orderStatusId;
    }

    /**
     * Sets the order status id.
     *
     * @param orderStatusId the new order status id
     */
    public void setOrderStatusId(final Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
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

}
