/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.exception;

import java.util.ArrayList;
import java.util.List;

import com.augmentum.ec.core.constant.ResponseCode;

/**
 * The Class JwfException.
 */
public class ECException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3843875618738029785L;

    /** The error messages. */
    private List<String> errorMessages;

    /** The code. */
    private ResponseCode code;

    /**
     * Instantiates a new EC exception.
     */
    public ECException() {
    }

    /**
     * Gets the error messages.
     *
     * @return the error messages
     */
    public final List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * Sets the error messages.
     *
     * @param errorMessages the new error messages
     */
    public final void setErrorMessages(final List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public final void setCode(final ResponseCode code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public final ResponseCode getCode() {
        return code;
    }

    /**
     * Adds the error message.
     *
     * @param message the message
     */
    public final void addErrorMessage(final String message) {
        if (null == errorMessages) {
            errorMessages = new ArrayList<String>();
        }
        errorMessages.add(message);
    }
}
