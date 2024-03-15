package com.jspiders.contactmanager.exception;

public class ContactInvalidMobileNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363757153457180465L;
	
	public ContactInvalidMobileNumberException (String message) {
		super(message);
	}

}
