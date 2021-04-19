package com.weitu.mpsplatform.commons.exception;

/**
 * 
 * 司法异常
 */
public class JudicialException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = -3543240895796979193L;

    public JudicialException() {
        super();
    }

    public JudicialException(String message) {
        super(message);
    }

    public JudicialException(String message, Throwable cause) {
        super(message, cause);
    }

    public JudicialException(Throwable cause) {
        super(cause);
    }
    
    public JudicialException(Object obj) {
        super();
    }

    public JudicialException(String message, Object obj) {
        super(message);
    }

    public JudicialException(String message, Throwable cause, Object obj) {
        super(message, cause);
    }

    public JudicialException(Throwable cause, Object obj) {
        super(cause);
    }
    
}
