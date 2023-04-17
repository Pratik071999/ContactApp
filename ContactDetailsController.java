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

import com.monocept.entity.ContactDetails;
import com.monocept.service.ContactDetailsService;

@RestController
@RequestMapping("/contactDetails")
public class ContactDetailsController {
	
	@Autowired
	private ContactDetailsService cDetailsService;
	
	
	@GetMapping("/getContacts")
	public List<ContactDetails> getAllContactDetails() {
		return cDetailsService.findAllContacts();
	}

	@GetMapping("/contact/{id}")
	public ContactDetails getContactById(@PathVariable int id) {
		return cDetailsService.findContactDetailsById(id);
	}

	@PostMapping("/save/{contactid}")
	public ContactDetails createContactDetails(@RequestParam int contactid, @RequestBody ContactDetails contact) {
		return cDetailsService.createNewContact(contactid, contact);
	}

	@PutMapping("/update")
	public ContactDetails editContactDetails(@RequestBody ContactDetails contact) {
		return cDetailsService.updateContactDetails(contact);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteContact(@PathVariable int id) {
		cDetailsService.deleteContactDetailsById(id);
	}


}
