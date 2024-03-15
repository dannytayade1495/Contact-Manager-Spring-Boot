package com.jspiders.contactmanager.exception;

public class ContactDuplicateMobileNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3071500634448124857L;
	
	public ContactDuplicateMobileNumberException(String messgae) {
		super(messgae);
	}

}
