/**
 * @author Vergil Ji <vergil.ji@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Jan 24, 2014
 */
package com.augmentum.ec.core.util;

import java.util.Properties;

/**
 * The Class ExceptionMessageUtil.
 */
public final class ExceptionMessageUtil {
    /** The exception message properties. */
    private static Properties exceptionMessageProperties;

    static {
        exceptionMessageProperties = PropertiesUtil.getProperties("/exception_message.properties");
    }

    /**
     * Instantiates a new exception message util.
     */
    private ExceptionMessageUtil() {
    }

    /**
     * Gets the exception message.
     *
     * @param code the code
     * @return the exception message
     */
    public static String getExceptionMessage(final int code) {
        return PropertiesUtil.get(exceptionMessageProperties, code + "");
    }
}
