package com.capgemini.app.exception;

public class NullException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullException(String message)
	{
		super(message);
	}

}