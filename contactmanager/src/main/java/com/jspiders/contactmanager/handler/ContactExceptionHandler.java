package com.jspiders.contactmanager.handler;

import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.INVALID_CONTACT_ID;
import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.INVALID_EMAIL;
import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.INVALID_MOBILE_NUMBER;
import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.DUPLICATE_EMAIL;
import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.DUPLICATE_MOBILE_NUMBER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.contactmanager.exception.ContactDuplicateEmailException;
import com.jspiders.contactmanager.exception.ContactDuplicateMobileNumberException;
import com.jspiders.contactmanager.exception.ContactInvalidEmailException;
import com.jspiders.contactmanager.exception.ContactInvalidIdException;
import com.jspiders.contactmanager.exception.ContactInvalidMobileNumberException;
import com.jspiders.contactmanager.response.ContactResponse;

@RestControllerAdvice
public class ContactExceptionHandler {

	@ExceptionHandler(ContactInvalidMobileNumberException.class)
	private ResponseEntity<ContactResponse> invalidMobileNumber() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(INVALID_MOBILE_NUMBER, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ContactInvalidIdException.class)
	private ResponseEntity<ContactResponse> invalidIdException() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(INVALID_CONTACT_ID, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(ContactInvalidEmailException.class)
	private ResponseEntity<ContactResponse> invalidEmailException() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(INVALID_EMAIL, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(ContactDuplicateEmailException.class)
	private ResponseEntity<ContactResponse> duplicateEmailException() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(DUPLICATE_EMAIL, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(ContactDuplicateMobileNumberException.class)
	private ResponseEntity<ContactResponse> duplicateMobileNumberException() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(DUPLICATE_MOBILE_NUMBER, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

}
