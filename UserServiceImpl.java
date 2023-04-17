package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.User;
import com.monocept.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Integer userId) {

		return userRepo.findById(userId).get();
	}

	@Override
	@Transactional
	public User createUser(User user) {
		user.setIsActive(true);
		user.setIsAdmin(false);
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public User updateUser(User updateUser) {
		return userRepo.save(updateUser);
	}

	@Override
	@Transactional
	public User deleteUserById(Integer userId) {
		userRepo.deleteById(userId);
		return null;
	}

}
