/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.core.util;

import net.sf.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.augmentum.ec.core.constant.ContentType;
import com.augmentum.ec.core.constant.ResponseCode;
import com.augmentum.ec.core.constant.ResponseStatus;

/**
 * The Class ResponseUtil.
 */
public final class ResponseUtil {

    /** The Constant RESPONSE_BODY. */
    public static final String RESPONSE_BODY = "body";

    /** The Constant RESPONSE_STATUS. */
    public static final String RESPONSE_STATUS = "status";

    /** The Constant RESPONSE_ERROR. */
    public static final String RESPONSE_ERROR = "error";

    /** The Constant RESPONSE_ERROR_CODE. */
    public static final String RESPONSE_ERROR_CODE = "code";

    /** The Constant RESPONSE_ERROR_MSG. */
    public static final String RESPONSE_ERROR_MSG = "msg";

    /**
     * Instantiates a new response util.
     */
    private ResponseUtil() {
        // empty
    }

    /**
     * Json succeed.
     *
     * @param object the object
     * @param statusCode the status code
     * @return the response entity
     */
    public static ResponseEntity<String> jsonSucceed(final Object object, final HttpStatus statusCode) {
        JSONObject jo = new JSONObject();
        Object responseBody = DataUtil.formatApiResponse(object);
        jo.accumulate(RESPONSE_BODY, responseBody);
        return wrapResponse(ResponseStatus.SUCCEED, jo, statusCode);
    }

    /**
     * Json failed.
     *
     * @param errorMessage the error message
     * @param statusCode the status code
     * @return the response entity
     */
    public static ResponseEntity<String> jsonFailed(final String errorMessage, final HttpStatus statusCode) {
        return jsonFailed(errorMessage, ResponseCode.SERVER_ERROR, statusCode);
    }

    /**
     * Json failed.
     *
     * @param errorMessage the error message
     * @param code the code
     * @param statusCode the status code
     * @return the response entity
     */
    public static ResponseEntity<String> jsonFailed(final Object errorMessage, final ResponseCode code,
            final HttpStatus statusCode) {
        JSONObject errorObj = new JSONObject();
        errorObj.accumulate(RESPONSE_ERROR_CODE, code.getValue());
        errorObj.accumulate(RESPONSE_ERROR_MSG, errorMessage);

        JSONObject error = new JSONObject();
        error.accumulate(RESPONSE_ERROR, errorObj);

        JSONObject jo = new JSONObject();
        jo.accumulate(RESPONSE_BODY, error);
        return wrapResponse(ResponseStatus.FAILED, jo, statusCode);
    }

    /**
     * Wrap response.
     *
     * @param status the status
     * @param body the body
     * @param statusCode the status code
     * @return the response entity
     */
    private static ResponseEntity<String> wrapResponse(final ResponseStatus status, final JSONObject body,
            final HttpStatus statusCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", ContentType.APPLICATION_JSON.getValue());

        if (ResponseStatus.SUCCEED.equals(status)) {
            body.accumulate(RESPONSE_STATUS, ResponseStatus.SUCCEED.toString());
        } else if (ResponseStatus.FAILED.equals(status)) {
            body.accumulate(RESPONSE_STATUS, ResponseStatus.FAILED.toString());
        }

        return new ResponseEntity<String>(body.toString(), headers, statusCode);
    }
}
