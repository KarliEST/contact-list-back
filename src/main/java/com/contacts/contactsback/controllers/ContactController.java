package com.contacts.contactsback.controllers;

import com.contacts.contactsback.requests.ContactRequest;
import com.contacts.contactsback.responses.ContactResponse;
import com.contacts.contactsback.sevices.ContactService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/")
public class ContactController {

	@Resource
	private ContactService contactService;

	@PostMapping("/post")
	public ContactResponse postContact(@Valid @RequestBody ContactRequest request) {
		return contactService.postContact(request);
	}

	@GetMapping("/get")
	public ContactResponse getContactById(@RequestParam int id) {
		return contactService.getContactById(id);
	}

	@PutMapping("/update")
	public ContactResponse updateContact(@RequestParam int id, @Valid @RequestBody ContactRequest request) {
		return contactService.updateContact(id, request);
	}

	@DeleteMapping("/delete")
	public String deleteContact(@RequestParam int id) {
		return contactService.deleteContact(id);
	}

	@GetMapping("/all")
	public List<ContactResponse> getAllContacts() {
		return contactService.getAllContacts();
	}

}
