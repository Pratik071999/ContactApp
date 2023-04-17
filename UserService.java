package com.monocept.service;

import java.util.List;

import com.monocept.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(Integer userId);

	User createUser(User user);

	User updateUser(User updateUser);

	User deleteUserById(Integer userId);

}
