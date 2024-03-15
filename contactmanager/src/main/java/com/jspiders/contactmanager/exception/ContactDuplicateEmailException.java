package com.jspiders.contactmanager.exception;

public class ContactDuplicateEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -830416230736094791L;

	public ContactDuplicateEmailException(String message) {
		super(message);
	}

}
