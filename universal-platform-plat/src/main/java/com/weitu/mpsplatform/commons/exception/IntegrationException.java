package com.weitu.mpsplatform.commons.exception;

/**
 * 
 * 三方异常
 */
public class IntegrationException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = -3543240895796979193L;

    public IntegrationException() {
        super();
    }

    public IntegrationException(String message) {
        super(message);
    }

    public IntegrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegrationException(Throwable cause) {
        super(cause);
    }

    public IntegrationException(Object obj) {
        super();
    }

    public IntegrationException(String message, Object obj) {
        super(message);
    }

    public IntegrationException(String message, Throwable cause, Object obj) {
        super(message, cause);
    }

    public IntegrationException(Throwable cause, Object obj) {
        super(cause);
    }
    
}
