package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	//GET the user with the uid matching the provided path variable.
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id); //path variable exracted as an int
	}
	
	//GET login credentials. Currently returns a user.
	@GetMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user); //creates User object from user data sent in request body and passes it to userService as args.
	}

	//POST - receive a user in the request body and save it to the database.
	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	//receive updated user data and PUT it into database. I've disabled the endpoint as this function isn't utilized.
//	@PutMapping("")
//	public User updateUser(@RequestBody User user) {
//		return userService.update(user);
//	}

}