/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.constant;


// TODO: Auto-generated Javadoc
/**
 * The Enum ResponseCode.
 */
public enum ResponseCode {

    // common error code 10000-19999
    /** The invalid parameter. */
    INVALID_PARAMETER(10000),

    // user common error code 20000-20099

    // user address related error code 20500-20599

    // product related 30000-39999
    // user common error code 30000-30099

    // user CURD error code 30100-30199

    // user like product related error code 30200-30299

    // user report product related error code 30300-30399

    // user comment product related error code 30400-30499

    // message related error code 40000-49999

    /** The bad request. */
    BAD_REQUEST(400),

    /** The unauthorized. */
    UNAUTHORIZED(401),

    /** The server error. */
    SERVER_ERROR(500);

    /** The value. */
    private int value;

    /**
     * Instantiates a new response code.
     *
     * @param value the value
     */
    private ResponseCode(final int value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
