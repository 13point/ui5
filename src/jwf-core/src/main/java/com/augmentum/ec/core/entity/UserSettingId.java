/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class UserSettingId.
 */
@Embeddable
public final class UserSettingId implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8918667695401052476L;

    /** The user id. */
    private Long userId;

    /** The path. */
    private String path;

    /**
     * Instantiates a new user setting id.
     */
    public UserSettingId() {
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
        if (!(other instanceof UserSettingId)) {
            return false;
        }
        UserSettingId castOther = (UserSettingId) other;

        return (this.getUserId() == castOther.getUserId())
                && ((this.getPath() == castOther.getPath())
                        || (this.getPath() != null && castOther.getPath() != null
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

        result = 37 * result + (userId != null ? userId.intValue() : 0);
        result = 37 * result + (getPath() == null ? 0 : this.getPath().hashCode());
        return result;
    }

}
