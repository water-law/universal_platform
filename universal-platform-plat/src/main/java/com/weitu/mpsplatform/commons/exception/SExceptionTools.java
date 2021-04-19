package com.weitu.mpsplatform.commons.exception;

/**
 * 异常处理工具
 */
public class SExceptionTools {
    private SExceptionTools(){
        
    }
    
    public static Throwable getException(Throwable e,Class exceptionType){
        if(e.getClass().getName().equals(exceptionType.getName()) || e.getClass().getName().equals(JudicialException.class.getName())){
            return e;
        }
        Throwable target=e.getCause();
        while(target!=null){
            Class targetClass=target.getClass();
            if(targetClass.getName().equals(exceptionType.getName()) || e.getClass().getName().equals(JudicialException.class.getName())){
                return target;
            }
            target=target.getCause();
        }
        return null;
    }

    /**
     * 获取异常对象
     * @param e
     * @return
     */
    public static Throwable getThrowable(Throwable e) {
        Throwable throwable = SExceptionTools.getException(e, JudicialException.class);
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, BaseException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, SysException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, BusinessException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, FileException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, ExcelException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, ParameterException.class);
        }
        if (throwable == null) {
            throwable = SExceptionTools.getException(e, IllegalArgumentException.class);
        }
        return throwable;
    }
    
}
