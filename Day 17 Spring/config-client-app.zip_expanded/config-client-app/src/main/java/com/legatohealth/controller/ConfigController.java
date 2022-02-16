package com.legatohealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legatohealth.beans.CustomMessage;
import com.legatohealth.beans.MessageBean;
import com.legatohealth.beans.User;
import com.legatohealth.exceptions.UserNotFoundException;
import com.legatohealth.service.UserService;

@RestController
@RequestMapping("config")
public class ConfigController {

	@Autowired
	private MessageBean bean;
	

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Object> readConfigMessage() {
		// getMessage() returns the value the config file has
		return ResponseEntity.status(200).body(bean.getMessage()+" , Password is : "+bean.getPassword());
	}
	
	@GetMapping("/test")
	public ResponseEntity<Object> testing(){
		User u = new User();
		u.setId(100);
		u.setAge(20);
		u.setName("Suresh");
		
		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK).body(u);
		return response;
	}
	
	@GetMapping("/user/{userID}")
	public ResponseEntity<Object> getUserById(@PathVariable("userID") int id){
		User user = new User();
		try {
			user = service.fetchUser(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(user);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<Object> getAllUsers(){
		List<User> users = service.fetchAllUsers();
		ResponseEntity<Object> response =  ResponseEntity.status(HttpStatus.OK).body(users);
		return response;
	}
	
	@PostMapping(path = "/user" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> store(@RequestBody User user){
		User userStored;
		try {
			userStored = service.store(user);
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.CREATED).body(userStored);
			return response;
		} catch (UserNotFoundException e) {
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomMessage("User not stored",HttpStatus.NOT_FOUND));
			return response;
		}
		
	}
	
	@DeleteMapping(path = "/user/{userID}")
	public ResponseEntity<Object> deleteUserById(@PathVariable("userID") int id){
		try {
			service.deleteUser(id);
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK).body(new CustomMessage("User with id "+id+" deleted successfully!", HttpStatus.OK));
			return response;
		} catch (UserNotFoundException e) {
			ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomMessage("User with id "+id+" Not found", HttpStatus.NOT_FOUND));
			return response;
		}
	}
	
	@PutMapping(path ="/user")
	public ResponseEntity<Object> updateDetails(@RequestBody User user){
		ResponseEntity<Object> response = null;
		try {
			service.store(user);
			response = ResponseEntity.status(HttpStatus.OK).body(new CustomMessage("User updated successfully",HttpStatus.OK));
			return response;
		} catch (UserNotFoundException e) {
			response = ResponseEntity.status(HttpStatus.OK).body(new CustomMessage("User not found with id "+user.getId()+" . Try again.",HttpStatus.NOT_FOUND));
			return response;
		}
	}
}
