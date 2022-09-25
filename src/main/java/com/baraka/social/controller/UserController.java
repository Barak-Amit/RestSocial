package com.baraka.social.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.baraka.social.Exception.UserNotFoundException;
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
		User user = dataService.getUser(id);

		if(user==null) {
			throw new UserNotFoundException("User with Id is not available."); 
		}

		return user;
	}


	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = dataService.save(user);

		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable Integer id) {
		System.out.println("Got new delete request");
		dataService.deleteUserById(id);
	}
}
