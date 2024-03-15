package com.jspiders.contactmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
//@Configuration
//@SwaggerDefinition
public class ContactmanagerApplication {

	/*
	 * @Bean public Docket apiDocket() { return new
	 * Docket(DocumentationType.SWAGGER_2); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
	}

}
