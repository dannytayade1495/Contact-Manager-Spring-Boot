package com.jspiders.contactmanager.exception;

public class ContactInvalidEmailException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5349544096381486050L;

	public ContactInvalidEmailException(String message) {
		super(message);
	}

}
