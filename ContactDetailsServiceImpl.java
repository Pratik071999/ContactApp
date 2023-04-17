package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.entity.ContactDetails;
import com.monocept.repo.ContactDetailsRepository;
import com.monocept.repo.ContactRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

	@Autowired
	private ContactDetailsRepository cDetailsRepo;

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public List<ContactDetails> findAllContacts() {
		return cDetailsRepo.findAll();
	}

	@Override
	public ContactDetails findContactDetailsById(int id) {
		Optional<ContactDetails> findById = cDetailsRepo.findById(id);
		if (!findById.isPresent()) {
			return null;
		}
		return findById.get();
	}

	@Override
	@Transactional
	public ContactDetails createNewContact(int contactid, ContactDetails contact) {
		Optional<Contact> contactD = contactRepo.findById(contactid);
		if (!contactD.isPresent()) {
			return null;
		}
		contact.setContact(contactD.get());
		ContactDetails save = cDetailsRepo.save(contact);
		return save;
	}

	@Override
	@Transactional
	public ContactDetails updateContactDetails(ContactDetails contact) {
		return cDetailsRepo.save(contact);
	}

	@Override
	@Transactional
	public void deleteContactDetailsById(int id) {
		cDetailsRepo.deleteById(id);

	}

}
