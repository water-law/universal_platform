package com.weitu.mpsplatform.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 系统业务异常
 * @author fsh
 */
public class BusinessException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message,Exception e) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(String message,Exception e, Throwable cause) {
		super(message, cause);
	}

}
