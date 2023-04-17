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
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.User;
import com.monocept.service.UserService;

@RestController
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;

	// End points for active all users
	@GetMapping("/getAllUsers")
	public List<User> getUser() {
		return userService.getAllUsers();
	}

	// get user by id
	@GetMapping("/getUserById/{userId}")
	public User getUserId(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	// create new user
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	// update user
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User updateUser) {
		return userService.updateUser(updateUser);
	}

	// delete user
	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable Integer userId) {
		return userService.deleteUserById(userId);
	}

}
