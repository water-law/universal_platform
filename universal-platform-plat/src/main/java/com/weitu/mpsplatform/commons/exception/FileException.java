package com.weitu.mpsplatform.commons.exception;

/**
 * 文件异常
 */
public class FileException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = -3543240895796979193L;

    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    public FileException(Object obj) {
        super();
    }

    public FileException(String message, Object obj) {
        super(message);
    }

    public FileException(String message, Throwable cause, Object obj) {
        super(message, cause);
    }

    public FileException(Throwable cause, Object obj) {
        super(cause);
    }
    
}
