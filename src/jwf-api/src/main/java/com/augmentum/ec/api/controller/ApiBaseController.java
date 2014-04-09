/**
 * @author Adrian.Yao <adrianyao@augmentum.com.cn>
 * @version 1.6
 * @since 2013 Dec 4, 2013
 */
package com.augmentum.ec.api.controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augmentum.ec.core.constant.CommonConstant;
import com.augmentum.ec.core.constant.ResponseCode;
import com.augmentum.ec.core.util.ResponseUtil;


/**
 * The Class ApiBaseController.
 */
public abstract class ApiBaseController {

    /**
     * Inits the binder.
     * 
     * @param request the request
     * @param binder the binder
     * @throws Exception the exception
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder)
            throws Exception {
        PropertyEditor editor = new CustomDateEditor(new SimpleDateFormat(CommonConstant.DATE_FORMAT_LONG), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    /**
     * Handle exception.
     * 
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public final ResponseEntity<String> handleException(final Throwable ex) {
        ex.printStackTrace();
        Object errorMessage = null;
        ResponseCode code = ResponseCode.SERVER_ERROR;
        boolean isDataValidationException = false;
        return ResponseUtil.jsonFailed(errorMessage, code, isDataValidationException
                ? HttpStatus.BAD_REQUEST
                : HttpStatus.OK);
    }

}
