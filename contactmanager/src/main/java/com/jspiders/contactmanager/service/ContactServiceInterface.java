package com.jspiders.contactmanager.service;

import java.util.List;

import com.jspiders.contactmanager.entity.Contact;

public interface ContactServiceInterface {

	public List<Contact> getContacts();

	public Contact addContact(Contact contact);

	public Contact editContact(Contact contact);

	public Contact deleteContact(Contact contact);

	public List<Contact> searchByFirstName(String firstName);

	public List<Contact> searchByLastName(String lastName);

	public Contact searchByMobileNumber(long mobileNumber);

	public Contact searchByEmail(String email);

	public List<Contact> searchByCompany(String company);

	public List<Contact> searchByGroup(String group);

}
