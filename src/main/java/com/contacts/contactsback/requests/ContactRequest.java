package com.contacts.contactsback.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactRequest {
	@NotBlank(message = "first name must not be empty")
	private String firstName;
	@NotBlank(message = "last name must not be empty")
	private String lastName;
	@NotBlank(message = "codename must not be empty")
	private String codename;
	@NotBlank(message = "phone number must not be empty")
	@Pattern(regexp = "^\\+(?:\\d\\s?){6,14}\\d$",
			message = "phone number must be in format: +CCC NNNNNNNNN(+372 987654321)")
	private String phoneNumber;

}
