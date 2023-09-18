package edu.sabanciuniv.it592api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public boolean addUser(@RequestBody User user) {
		user.setId(0);
		if(user.getManager() != null && user.getManager().getId()==0)
			user.setManager(null);
		return userService.save(user);
	}
	@GetMapping("/user")
	public List<User> getUserAll() {
		return userService.findAll();
	}
	@PutMapping("/user")
	public boolean updateUser(@RequestBody User theUser) {
		return userService.update(theUser);
	}
	
	@GetMapping("/user/{userId}")
	public User getUserWithId(@PathVariable int userId) {
		return userService.findById(userId);
	}
	@DeleteMapping("/user/{userId}")
	public boolean deleteUser(@PathVariable int userId) {
		if(userId == 0)
			return false;
		return userService.delete(userId);
	}
	
	@GetMapping("/user/{companyId}/{password}")
	public User userLogin(@PathVariable String companyId, @PathVariable String password) {
		return userService.userLogin(companyId, password);
	}
	
	@GetMapping("/user/manager")
	public List<User> getAllManagers() {
		return userService.findAllManager();
	}
	@GetMapping("/user/pm")
	public List<User> getAllPm() {
		return userService.findAllPm();
	}
	@GetMapping("/user/electric")
	public List<User> getAllElectic() {
		return userService.findAllElectric();
	}
	@GetMapping("/user/mechanic")
	public List<User> getAllMechanic() {
		return userService.findAllMechanic();
	}
}
