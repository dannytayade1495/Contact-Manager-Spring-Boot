package com.jspiders.contactmanager.controller;

import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACTS_FOUND;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACTS_NOT_FOUND;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_ADDED;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_NOT_ADDED;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_NOT_REMOVED;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_REMOVED;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_NOT_EDITED;
import static com.jspiders.contactmanager.constants.ContactControllerConstants.CONTACT_EDITED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.contactmanager.entity.Contact;
import com.jspiders.contactmanager.response.ContactResponse;
import com.jspiders.contactmanager.service.ContactService;

@RestController
@CrossOrigin("*")
public class ContactController {

	@Autowired
	private ContactService service;

	@GetMapping("/getContacts")
	private ResponseEntity<ContactResponse> getContacts() {
		List<Contact> contacts = service.getContacts();
		if (!contacts.isEmpty()) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, null, contacts), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, null, null), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addContact")
	private ResponseEntity<ContactResponse> addContact(@RequestBody Contact contact){
		Contact addContact = service.addContact(contact);
		if (addContact != null) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_ADDED, addContact, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_NOT_ADDED, addContact, null), HttpStatus.NOT_ACCEPTABLE);

	}
	
	@DeleteMapping("/deleteContact")
	private ResponseEntity<ContactResponse> deleteContact(@RequestBody Contact contact){
		Contact foundContact = service.deleteContact(contact);
		if (foundContact != null) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_REMOVED, null, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_NOT_REMOVED, null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PutMapping("/editContact")
	private ResponseEntity<ContactResponse> editContact(@RequestBody Contact contact){
		Contact foundContact = service.editContact(contact);
		if (foundContact != null) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_EDITED, null, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACT_NOT_EDITED, null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/searchByFirstName")
	private ResponseEntity<ContactResponse> searchByFirstName(@RequestParam String firstName){
		List<Contact> contacts = service.searchByFirstName(firstName);
		if (!contacts.isEmpty()) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, null, contacts), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, null, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchBylastName")
	private ResponseEntity<ContactResponse> searchByLastName(@RequestParam String lastName){
		List<Contact> contacts = service.searchByLastName(lastName);
		if (!contacts.isEmpty()) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, null, contacts), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, null, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByMobileNumber")
	private ResponseEntity<ContactResponse> searchByMobileNumber(@RequestParam long mobileNumber){
		Contact contact = service.searchByMobileNumber(mobileNumber);
		if (contact != null) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, contact, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, contact, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByEmail")
	private ResponseEntity<ContactResponse> searchByMobileNumber(@RequestParam String email){
		Contact contact = service.searchByEmail(email);
		if (contact != null) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, contact, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, contact, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByCompany")
	private ResponseEntity<ContactResponse> searchByCompany(@RequestParam String company){
		List<Contact> contacts = service.searchByCompany(company);
		if (!contacts.isEmpty()) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, null, contacts), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, null, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByGroup")
	private ResponseEntity<ContactResponse> searchByGroup(@RequestParam String group){
		List<Contact> contacts = service.searchByGroup(group);
		if (!contacts.isEmpty()) {
			return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_FOUND, null, contacts), HttpStatus.FOUND);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse(CONTACTS_NOT_FOUND, null, null), HttpStatus.NOT_FOUND);
	}

}
