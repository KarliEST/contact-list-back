package com.contacts.contactsback.sevices;

import com.contacts.contactsback.models.Contact;
import com.contacts.contactsback.repositories.ContactRepository;
import com.contacts.contactsback.requests.ContactRequest;
import com.contacts.contactsback.responses.ContactResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

	@Resource
	ContactRepository contactRepository;

	@Override
	public List<ContactResponse> getAllContacts() {
		return contactRepository
				.findAll()
				.stream()
				.map(this::entityToResponse)
				.toList();
	}

	@Override
	public ContactResponse getContactById(int id) {
		Contact contact = contactRepository.getReferenceById(id);
		return entityToResponse(contact);
	}

	@Override
	public ContactResponse postContact(ContactRequest request) {
		Contact contact = requestToEntity(request);
		return entityToResponse(contactRepository.save(contact));
	}

	@Override
	public ContactResponse updateContact(int id, ContactRequest request) {
		contactRepository.findById(id)
				.map(contact -> {
					contact.setFirstName(request.getFirstName().trim());
					contact.setLastName(request.getLastName().trim());
					contact.setCodename(request.getCodename().trim());
					contact.setPhoneNumber(request.getPhoneNumber().trim());
					return contactRepository.save(contact);
				});
		return entityToResponse(contactRepository.getReferenceById(id));
	}

	@Override
	public String deleteContact(int id) {
		contactRepository.delete(contactRepository.getReferenceById(id));
		return "contact with id: " + id + " deleted";
	}

	private Contact requestToEntity(ContactRequest request) {
		Contact contact = new Contact();
		contact.setFirstName(request.getFirstName().trim());
		contact.setLastName(request.getLastName().trim());
		contact.setCodename(request.getCodename().trim());
		contact.setPhoneNumber(request.getPhoneNumber().trim());
		return contact;
	}

	private ContactResponse entityToResponse(Contact contact) {
		ContactResponse response = new ContactResponse();
		response.setId(contact.getId());
		response.setFirstName(contact.getFirstName());
		response.setLastName(contact.getLastName());
		response.setCodename(contact.getCodename());
		response.setPhoneNumber(contact.getPhoneNumber());
		return response;
	}
}
