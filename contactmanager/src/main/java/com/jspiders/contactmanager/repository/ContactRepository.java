package com.jspiders.contactmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.contactmanager.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	List<Contact> findByFirstName(String firstName);
	List<Contact> findByLastName(String lastName);
	Contact findByMobileNumber(long mobileNumber);
	Contact findByEmail(String email);
	List<Contact> findByCompany(String company);
	List<Contact> findByGroup(String group);

}
