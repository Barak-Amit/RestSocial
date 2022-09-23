package com.baraka.social.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baraka.social.dao.User;
import com.baraka.social.dataservice.UserDataService;

@RestController
public class UserController {

	private UserDataService dataService;

	public UserController(UserDataService dataService) {
		super();
		this.dataService = dataService;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return dataService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id) {
		return dataService.getUser(id);
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		dataService.save(user);
	}
}
