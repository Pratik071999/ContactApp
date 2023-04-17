package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.entity.User;
import com.monocept.repo.ContactRepository;
import com.monocept.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Contact> findAllContacts() {
		return contactRepo.findAll();
	}

	@Override
	public Contact findContactById(int contactid) {
		Optional<Contact> findById = contactRepo.findById(contactid);
		if (!findById.isPresent()) {
			return null;
		}
		return findById.get();
	}

	@Override
	@Transactional
	public Contact createNewContact(int userid, Contact contact) {
		Optional<User> user = userRepo.findById(userid);
		if (!user.isPresent()) {
			return null;
		}
		contact.setUser(user.get());
		return contactRepo.save(contact);
	}

	@Override
	@Transactional
	public Contact updateContact(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	@Transactional
	public void deleteContactId(int id) {
		contactRepo.deleteById(id);
	}

}
