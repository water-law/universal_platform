package com.weitu.mpsplatform.commons.exception;

/**
 * 系统异常
 */
public class SysException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -1356719174589626211L;
    private Object obj;

    public SysException() {
        super();
    }

    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysException(Throwable cause) {
        super(cause);
    }
    
    public SysException(Object obj) {
        super();
        this.obj=obj;
    }

    public SysException(String message,Object obj) {
        super(message);
        this.obj=obj;
    }

    public SysException(String message, Throwable cause,Object obj) {
        super(message, cause);
        this.obj=obj;
    }

    public SysException(Throwable cause,Object obj) {
        super(cause);
        this.obj=obj;
    }
    
    public Object getObject(){
        return obj;
    }
}