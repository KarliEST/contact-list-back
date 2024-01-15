package com.contacts.contactsback.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contacts", schema = "public", catalog = "")
public class Contact {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "first_name")
	private String firstName;
	@Basic
	@Column(name = "last_name")
	private String lastName;
	@Basic
	@Column(name = "code_name")
	private String codename;
	@Basic
	@Column(name = "phone_number")
	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contact contacts = (Contact) o;
		return id == contacts.id && Objects.equals(firstName, contacts.firstName) && Objects.equals(lastName, contacts.lastName) && Objects.equals(codename, contacts.codename) && Objects.equals(phoneNumber, contacts.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, codename, phoneNumber);
	}
}
