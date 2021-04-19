/**
 * @(#)ParameterException.java 2011-12-20 Copyright 2011 it.kedacom.com, Inc.
 *                             All rights reserved.
 */

package com.weitu.mpsplatform.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 参数异常
 */

public class ParameterException extends RuntimeException {

	private static final long serialVersionUID = 6417641452178955756L;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}
	
	public ParameterException(String message,Exception e) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ParameterException(String message,Exception e, Throwable cause) {
		super(message, cause);
	}
}
