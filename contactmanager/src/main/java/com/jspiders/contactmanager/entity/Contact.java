package com.jspiders.contactmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_details")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "first_name")
//	@Pattern(regexp = "^[A-Za-z]*$", message = "First name can include only alphabets. ")
	private String firstName;
	@Column(name = "last_name")
//	@Pattern(regexp = "^[A-Za-z]*$", message = "Last name can include only alphabets. ")
	private String lastName;
	@Column(name = "mobile_number")
	private long mobileNumber;
	private String email;
	private String company;
	@Column(name = "contact_group")
	private String group;

}
