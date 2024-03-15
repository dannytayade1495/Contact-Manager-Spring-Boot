package com.jspiders.contactmanager.service;

import static com.jspiders.contactmanager.constants.ContactServiceConstants.EMAIL_INVALID_EXCEPTION;
import static com.jspiders.contactmanager.constants.ContactServiceConstants.INVALID_CONTACT_ID;
import static com.jspiders.contactmanager.constants.ContactServiceConstants.MOBILE_NUMBER_INVALID_LENGTH;
import static com.jspiders.contactmanager.constants.ContactServiceConstants.DUPLICATE_EMAIL;
import static com.jspiders.contactmanager.constants.ContactServiceConstants.DUPLICATE_MOBILE_NUMBER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.contactmanager.entity.Contact;
import com.jspiders.contactmanager.exception.ContactDuplicateEmailException;
import com.jspiders.contactmanager.exception.ContactDuplicateMobileNumberException;
import com.jspiders.contactmanager.exception.ContactInvalidEmailException;
import com.jspiders.contactmanager.exception.ContactInvalidIdException;
import com.jspiders.contactmanager.exception.ContactInvalidMobileNumberException;
import com.jspiders.contactmanager.repository.ContactRepository;

@Service
public class ContactService implements ContactServiceInterface {

	@Autowired
	private ContactRepository repository;

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = repository.findAll();
		return contacts;
	}

	@Override
	public Contact addContact(Contact contact) {
		List<Contact> allContacts = repository.findAll();
		for (Contact contact2 : allContacts) {
			if (contact2.getEmail().equalsIgnoreCase(contact.getEmail())) {
				throw new ContactDuplicateEmailException(DUPLICATE_EMAIL);
			} else if (contact2.getMobileNumber() == contact.getMobileNumber()) {
				throw new ContactDuplicateMobileNumberException(DUPLICATE_MOBILE_NUMBER);
			}
		}
		if (contact.getEmail().contains(" ")
				|| !contact.getEmail().contains("@") && (!contact.getEmail().endsWith(".com")
						|| !contact.getEmail().endsWith(".in") || !contact.getEmail().endsWith(".org"))) {
			throw new ContactInvalidEmailException(EMAIL_INVALID_EXCEPTION);
		}

		int mobileNumberLength = String.valueOf(contact.getMobileNumber()).length();
		if (mobileNumberLength != 10) {
			throw new ContactInvalidMobileNumberException(MOBILE_NUMBER_INVALID_LENGTH);
		}

		Contact addedContact = repository.save(contact);
		return addedContact;
	}

	@Override
	public Contact editContact(Contact contact) {
		List<Contact> allContacts = repository.findAll();
		for (Contact contact2 : allContacts) {
			if (contact2.getEmail().equalsIgnoreCase(contact.getEmail())) {
				throw new ContactDuplicateEmailException(DUPLICATE_EMAIL);
			} else if (contact2.getMobileNumber() == contact.getMobileNumber()) {
				throw new ContactDuplicateMobileNumberException(DUPLICATE_MOBILE_NUMBER);
			}
		}
		if (contact.getEmail().contains(" ")
				|| !contact.getEmail().contains("@") && (!contact.getEmail().endsWith(".com")
						|| !contact.getEmail().endsWith("in") || !contact.getEmail().endsWith("org"))) {
			throw new ContactInvalidEmailException(EMAIL_INVALID_EXCEPTION);
		}

		int mobileNumberLength = String.valueOf(contact.getMobileNumber()).length();
		if (mobileNumberLength != 10) {
			throw new ContactInvalidMobileNumberException(MOBILE_NUMBER_INVALID_LENGTH);
		}
		Contact foundContact = repository.findById(contact.getId()).orElse(null);
		if (foundContact != null) {
			repository.save(foundContact);
			return foundContact;
		} else {
			throw new ContactInvalidIdException(INVALID_CONTACT_ID);
		}
	}

	@Override
	public Contact deleteContact(Contact contact) {
		Contact foundContact = repository.findById(contact.getId()).orElse(null);
		if (foundContact != null) {
			repository.delete(foundContact);
			return foundContact;
		} else {
			throw new ContactInvalidIdException(INVALID_CONTACT_ID);
		}
	}

	@Override
	public List<Contact> searchByFirstName(String firstName) {
		List<Contact> contacts = repository.findByFirstName(firstName);
		if (!contacts.isEmpty()) {
			return contacts;
		}
		return null;
	}

	@Override
	public List<Contact> searchByLastName(String lastName) {
		List<Contact> contacts = repository.findByLastName(lastName);
		if (!contacts.isEmpty()) {
			return contacts;
		}
		return null;
	}

	@Override
	public Contact searchByMobileNumber(long mobileNumber) {
		Contact contact = repository.findByMobileNumber(mobileNumber);
		if (contact != null) {
			return contact;
		}
		return null;
	}

	@Override
	public Contact searchByEmail(String email) {
		Contact contact = repository.findByEmail(email);
		if (contact != null) {
			return contact;
		}
		return null;
	}

	@Override
	public List<Contact> searchByCompany(String company) {
		List<Contact> contacts = repository.findByCompany(company);
		if (!contacts.isEmpty()) {
			return contacts;
		}
		return null;
	}

	@Override
	public List<Contact> searchByGroup(String group) {
		List<Contact> contacts = repository.findByGroup(group);
		if (!contacts.isEmpty()) {
			return contacts;
		}
		return null;
	}

}
