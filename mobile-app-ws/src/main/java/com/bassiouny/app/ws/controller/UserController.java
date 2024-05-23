package com.bassiouny.app.ws.controller;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bassiouny.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.bassiouny.app.ws.ui.model.request.UserDetailsRequestModel;
import com.bassiouny.app.ws.ui.model.response.UserRest;
import com.bassiouny.app.ws.userservice.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;

	@GetMapping()
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) 
	{
		
		return "get Users, page: " + page + ", limit:" + limit;
	}

	@GetMapping(path = "/{userId}", 
			produces= {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) 
	{
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK); 
		} else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND); 
		}
	}

	@PostMapping(
			produces = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					}, 
			consumes = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					}
			)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userReq) 
	{
		UserRest user = userService.createUser(userReq);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}",
			produces = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					}, 
			consumes = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) 
	{
		UserRest existingUser = users.get(userId);
		if(existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		existingUser.setFirstName(userDetails.getFirstName());
		existingUser.setLastName(userDetails.getLastName());
		return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) 
	{
		users.remove(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
