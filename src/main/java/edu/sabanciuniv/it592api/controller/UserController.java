package edu.sabanciuniv.it592api.controller;

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

import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public boolean addUser(@RequestBody User theUser) {
		theUser.setId(0);
		return userService.add(theUser);
	}
	
	@DeleteMapping("/user/{userId}")
	public boolean deleteUser(@PathVariable int userId) {
		return userService.delete(userId);
	}
	
	@GetMapping("/user")
	public List<User> getUserAll() {
		return userService.findAll();
	}
	@GetMapping("/user/{userId}")
	public User getUserWithId(@PathVariable int userId) {
		return null;
	}
	
	@PutMapping("/user")
	public boolean updateUser(@RequestBody User theUser) {
		return userService.update(theUser);
	}
	
}
