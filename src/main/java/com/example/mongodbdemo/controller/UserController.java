package com.example.mongodbdemo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbdemo.model.User;
import com.example.mongodbdemo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    UserRepository userRepo;
	
	@GetMapping("/")
	public List<User> getAllUser() {
		logger.info("Fetching all the user details");
		List<User> userList = userRepo.findAll();
		return userList;
	}
	
	@GetMapping("/{id}")
	User getUserById(@PathVariable String id) {
		logger.info("Fetching the user details from id");
		Optional<User> user = userRepo.findById(id); 
		return user.get();
	}
	
	@PostMapping("/add")
	public String createUser(@RequestBody User user) {
		logger.info("Adding new user");
		userRepo.save(user);
		return "success";
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable String id){
		logger.info("updatig the user details with id");
		User oldUser = getUserById(id);
		oldUser.setCity(user.getCity());
		oldUser.setHobbies(user.getHobbies());
		oldUser.setSalary(user.getSalary());
		userRepo.save(oldUser);
	
		return "updated";
	}
	
	@DeleteMapping("/remove/{id}")
	String removeUser(@PathVariable String id) {
		logger.info("Removing user details");
		userRepo.deleteById(id);
		return "removed";
	}
}
