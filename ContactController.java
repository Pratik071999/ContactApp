package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Contact;
import com.monocept.service.ContactService;

@RestController
@RequestMapping("/contactuser")
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/getContacts")
	public List<Contact> getAllContact() {
		return contactService.findAllContacts();
	}

	@GetMapping("/contact/{contactid}")
	public Contact getContactById(@PathVariable int contactid) {
		return contactService.findContactById(contactid);
	}

	@PostMapping("/save/{userid}")
	public Contact createContact(@RequestParam int userid, @RequestBody Contact contact) {
		return contactService.createNewContact(userid, contact);
	}

	@PutMapping("/update")
	public Contact editContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteContact(@PathVariable int id) {
		contactService.deleteContactId(id);
	}

}
