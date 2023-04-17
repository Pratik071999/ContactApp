package com.monocept.service;

import java.util.List;
import com.monocept.entity.ContactDetails;

public interface ContactDetailsService {

	List<ContactDetails> findAllContacts();

	ContactDetails findContactDetailsById(int id);

	ContactDetails createNewContact(int contactid, ContactDetails contact);

	ContactDetails updateContactDetails(ContactDetails contact);

	void deleteContactDetailsById(int id);

}
