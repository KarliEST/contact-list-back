package com.contacts.contactsback.sevices;

import com.contacts.contactsback.requests.ContactRequest;
import com.contacts.contactsback.responses.ContactResponse;

import java.util.List;

public interface ContactService {

	List<ContactResponse> getAllContacts();

	ContactResponse getContactById(int id);

	ContactResponse postContact(ContactRequest request);

	ContactResponse updateContact(int id, ContactRequest request);

	String deleteContact(int id);
}
