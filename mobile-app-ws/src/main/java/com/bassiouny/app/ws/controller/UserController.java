package com.bassiouny.app.ws.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bassiouny.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

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
	public UserRest getUser(@PathVariable String userId) 
	{
		UserRest user = new UserRest();
		user.setFirstName("Abdelrahman");
		user.setLastName("Bassiouni");
		user.setEmail("abdelrhman.fathy@gmail.com");
		
		return user;

	}

	@PostMapping
	public String createUser() 
	{
		return "add user";
	}

	@PutMapping
	public String updateUser() 
	{
		return "update user";
	}

	@DeleteMapping
	public String deleteUser() 
	{
		return "delete user";
	}

}
