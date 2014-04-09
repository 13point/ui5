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
 * The Class MessageType.
 */
@Entity
@Table(name = "message_type", catalog = "ec_core")
public final class MessageType implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3264669034714092234L;

    /** The message type id. */
    private Integer messageTypeId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The icon. */
    private String icon;

    /**
     * Instantiates a new message type.
     */
    public MessageType() {
    }

    /**
     * Gets the message type id.
     *
     * @return the message type id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "message_type_id", unique = true, nullable = false)
    public Integer getMessageTypeId() {
        return this.messageTypeId;
    }

    /**
     * Sets the message type id.
     *
     * @param messageTypeId the new message type id
     */
    public void setMessageTypeId(final Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
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

}
