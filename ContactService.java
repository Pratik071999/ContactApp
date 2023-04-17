package com.monocept.service;

import java.util.List;

import com.monocept.entity.Contact;

public interface ContactService {

	List<Contact> findAllContacts();

	Contact findContactById(int contactid);

	Contact createNewContact(int userid, Contact contact);

	Contact updateContact(Contact contact);

	void deleteContactId(int id);

}
