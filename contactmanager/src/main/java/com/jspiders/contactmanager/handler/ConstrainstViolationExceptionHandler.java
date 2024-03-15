package com.jspiders.contactmanager.handler;

import static com.jspiders.contactmanager.constants.ContactExceptionHandlerConstants.INVALID_MOBILE_NUMBER;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.contactmanager.response.ContactResponse;

@RestControllerAdvice
public class ConstrainstViolationExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<ContactResponse> invalidMobileNumber() {
		return new ResponseEntity<ContactResponse>(new ContactResponse(INVALID_MOBILE_NUMBER, null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}
	
}
