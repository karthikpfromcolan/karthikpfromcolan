package com.example.mongodbdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
	
	@Autowired
    UserRepository userRepo;
	
	@GetMapping("/")
	public List<User> getAllUser() {
		System.out.println("all users");
		List<User> userList = userRepo.findAll();
		System.out.println(userList.size());
		System.out.println(userList.toString());
		return userList;
	}
	
	@GetMapping("/{id}")
	User getUserById(@PathVariable Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
	
	@PostMapping("/add")
	public String createUser(@RequestBody User user) {
		System.out.println("adding user");
		System.out.println(user.toString());
//		user.setId(getNextSequence("user"));
		userRepo.save(user);
		return "success";
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable Long id){
		
		User oldUser = getUserById(id);
		oldUser.setCity(user.getCity());
		oldUser.setHobbies(user.getHobbies());
		oldUser.setSalary(user.getSalary());
		userRepo.save(oldUser);
	
		return "updated";
	}
	
	@DeleteMapping("/remove/{id}")
	String removeUser(@PathVariable Long id) {
		userRepo.deleteById(id);
		return "removed";
	}
	
	
//	@Autowired private MongoOperations mongo;
//
//    public String getNextSequence(String seqName)
//    {
//        User counter = mongo.findAndModify(
//            query(where("_id").is(seqName)),
//            new Update().inc("seq",1),
//            options().returnNew(true).upsert(true),
//            User.class);
//        return counter.getId();
//    }
}
