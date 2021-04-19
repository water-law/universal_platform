package com.weitu.mpsplatform.commons.exception.handler;

import com.weitu.mpsplatform.commons.constants.SaasPlatConstants;
import com.weitu.mpsplatform.commons.exception.*;
import com.weitu.mpsplatform.commons.utils.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常统一处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponse exceptionHandle(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder("【参数校验不通过】");
        if (null == e) {
            return MessageResponse.getFailMessage(sb.toString());
        }
        if (null == e.getBindingResult()) {
            return MessageResponse.getFailMessage(sb.toString());
        }
        List<ObjectError> errorObjects = e.getBindingResult().getAllErrors();
        if (CollectionUtils.isEmpty(errorObjects)) {
            return MessageResponse.getFailMessage(sb.toString());
        }
        for (ObjectError error : errorObjects) {
            if (null == error || null == error.getDefaultMessage()) {
                continue;
            }
            sb.append("[").append(error.getDefaultMessage()).append("] ");
        }
        logger.info(sb.toString());
        return MessageResponse.getFailMessage(sb.toString());
    }

    /**
     * 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public MessageResponse exceptionHandle(Exception e) {
        logger.error(Thread.currentThread().getName() + "  ---统一拦截异常处理，当前异常为-----", e);
        Throwable throwable = SExceptionTools.getThrowable(e);
        if (throwable != null) {
            return new MessageResponse(MessageResponse.MessageType.FAIL, throwable.getMessage());
        }
        return new MessageResponse(MessageResponse.MessageType.FAIL, SaasPlatConstants.MessageConstants.SYSTEM_ERROR_MESSAGE);
    }



}
