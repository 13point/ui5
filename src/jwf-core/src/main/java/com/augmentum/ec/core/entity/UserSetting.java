/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class UserSetting.
 */
@Entity
@Table(name = "user_setting", catalog = "ec_core")
public final class UserSetting implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1986629125904145835L;

    /** The id. */
    private UserSettingId id;

    /** The data. */
    private String data;

    /** The created. */
    private Date created;

    /** The updated. */
    private Date updated;

    /**
     * Instantiates a new user setting.
     */
    public UserSetting() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
        @AttributeOverride(name = "path", column = @Column(name = "path", nullable = false)) })
    public UserSettingId getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final UserSettingId id) {
        this.id = id;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    @Column(name = "data", length = 65535)
    public String getData() {
        return this.data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(final String data) {
        this.data = data;
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
