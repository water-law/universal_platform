package com.weitu.mpsplatform.commons.exception;

/**
 * excel异常
 */
public class ExcelException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = -3543240895796979193L;

    public ExcelException() {
        super();
    }

    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelException(Throwable cause) {
        super(cause);
    }

    public ExcelException(Object obj) {
        super();
    }

    public ExcelException(String message, Object obj) {
        super(message);
    }

    public ExcelException(String message, Throwable cause, Object obj) {
        super(message, cause);
    }

    public ExcelException(Throwable cause, Object obj) {
        super(cause);
    }
    
}
