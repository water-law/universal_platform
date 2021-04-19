package com.weitu.mpsplatform.commons.page;


/**
 * 分页处理异常
 * 
 * @author fsh
 */
public class PageExeception extends RuntimeException {
    /**  */
    private static final long serialVersionUID = 613029941928729769L;

    public PageExeception() {
        super();
    }

    public PageExeception(String message) {
        super(message);
    }

    public PageExeception(String message, Throwable cause) {
        super(message, cause);
    }

    public PageExeception(Throwable cause) {
        super(cause);
    }
    
    public PageExeception(Object obj) {
        super();
    }

    public PageExeception(String message,Object obj) {
        super(message);
    }

    public PageExeception(String message, Throwable cause,Object obj) {
        super(message, cause);
    }

    public PageExeception(Throwable cause,Object obj) {
        super(cause);
    }
    
}