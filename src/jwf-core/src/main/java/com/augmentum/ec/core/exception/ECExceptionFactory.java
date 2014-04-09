/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.exception;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.augmentum.ec.core.constant.ResponseCode;

/**
 * A factory for creating ECException objects.
 */
public final class ECExceptionFactory {

    /** The Constant LOGGER. */
    public static final Logger LOGGER = Logger.getLogger(ECExceptionFactory.class);

    /**
     * Instantiates a new EC exception factory.
     */
    private ECExceptionFactory() {
    }

    /**
     * Gets the EC exception.
     *
     * @param <T> the generic type
     * @param exceptionClass the exception class
     * @param code the code
     * @param messages the messages
     * @return the EC exception
     */
    public static <T extends ECException> T getException(final Class<T> exceptionClass, final ResponseCode code, final String... messages) {
        T t = null;
        if (null != messages) {
            List<String> messageList = Arrays.asList(messages);
            t = getException(exceptionClass, code, messageList);

        }
        return t;
    }

    /**
     * Gets the EC exception.
     *
     * @param <T> the generic type
     * @param exceptionClass the exception class
     * @param code the code
     * @param messages the messages
     * @return the EC exception
     */
    public static <T extends ECException> T getException(final Class<T> exceptionClass, final ResponseCode code, final List<String> messages) {
        T t = null;
        try {
            t = exceptionClass.newInstance();
            for (String message : messages) {
                t.addErrorMessage(message);
            }
            t.setCode(code);
        } catch (InstantiationException e) {
            LOGGER.debug(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            LOGGER.debug(e.getMessage(), e);
        }
        return t;
    }
}
