/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.constant;

/**
 * The Enum ContentType.
 */
public enum ContentType {

    /** The application json. */
    APPLICATION_JSON("application/json;charset=UTF-8"),
    /** The application xml. */
    APPLICATION_XML("application/xml;charset=UTF-8");

    /** The value. */
    private String value;

    /**
     * Instantiates a new content type.
     * 
     * @param value the value
     */
    ContentType(final String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
