package com.weitu.mpsplatform.commons.exception;

/**
 * 基础异常处理
 * 
 * @author fsh
 */
public class BaseException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = 4204309683121219398L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
    
    public BaseException(Object obj) {
        super();
    }

    public BaseException(String message,Object obj) {
        super(message);
    }

    public BaseException(String message, Throwable cause,Object obj) {
        super(message, cause);
    }

    public BaseException(Throwable cause,Object obj) {
        super(cause);
    }
    
}
