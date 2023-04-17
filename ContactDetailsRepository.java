package com.monocept.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.monocept.entity.Contact;
import com.monocept.entity.ContactDetails;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer>{
	List<ContactDetails> findByContact(Contact Type);

}
