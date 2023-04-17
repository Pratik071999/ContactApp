package com.monocept.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.monocept.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("Select u from User u where u.userId = :userId and u.isActive= true")
	User findByIdAndIsActive(Integer userId);
}
