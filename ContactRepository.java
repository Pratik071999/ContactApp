package com.monocept.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.monocept.entity.Contact;
import com.monocept.entity.User;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	List<Contact> findByUser(User User);

}
