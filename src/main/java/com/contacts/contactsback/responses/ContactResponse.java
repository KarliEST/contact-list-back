package com.contacts.contactsback.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String codename;
	private String phoneNumber;

}
