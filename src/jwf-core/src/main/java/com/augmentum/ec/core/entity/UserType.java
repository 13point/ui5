/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UserType.
 */
@Entity
@Table(name = "user_type", catalog = "ec_core")
public final class UserType implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7598666943204024602L;

    /** The user type id. */
    private Integer userTypeId;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /**
     * Instantiates a new user type.
     */
    public UserType() {
    }

    /**
     * Gets the user type id.
     *
     * @return the user type id
     */
    @Id
    @Column(name = "user_type_id", unique = true, nullable = false)
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
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 45)
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
    @Column(name = "description", nullable = false, length = 45)
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
