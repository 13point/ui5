/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */

package com.augmentum.ec.core.constant;

/**
 * The Enum UserStatus.
 */
public enum UserStatus {

    /** The active. */
    ACTIVE("active"),

    /** The locked. */
    LOCKED("locked"),

    /** The banned. */
    BANNED("banned"),

    /** The deleted. */
    DELETED("deleted");

    /**
     * Instantiates a new user status.
     *
     * @param value the value
     */
    private UserStatus(final String value) {
        this.value = value;
    }

    /** The value. */
    private String value;

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the type.
     *
     * @param value the value
     * @return the type
     */
    public static UserStatus getType(final String value) {
        UserStatus[] types = values();
        for (UserStatus type : types) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
