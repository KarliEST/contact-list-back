package com.contacts.contactsback.repositories;

import com.contacts.contactsback.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
