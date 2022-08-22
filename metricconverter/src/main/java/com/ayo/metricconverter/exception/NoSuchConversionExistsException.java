package com.ayo.metricconverter.exception;

/**
 * 
 * @author Indu John
 *
 */
public class NoSuchConversionExistsException extends RuntimeException {

	private static final long serialVersionUID = 8460356990632230194L;

	public NoSuchConversionExistsException(String errorMessage) {
		super(errorMessage);
	}

}
