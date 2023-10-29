package com.Api.CRUDPractice.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.CRUDPractice.models.User;
import com.Api.CRUDPractice.services.UserService;

@RestController
@RequestMapping("/user")					//Tambien la podemos definir dentro de application.properties
public class UserControllers {
	
	@Autowired 
	UserService userService;
	
	@GetMapping
	public ArrayList<User> getUser(){
		return userService.getUsers();
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<User> getUserById(@PathVariable long id){
		return userService.getById(id);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User request, @PathVariable Long id) {
		return userService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable Long id) {
		boolean ok = userService.deleteUser(id);
		
		if(ok) {
			return  "user delete with id:" + id;
		} else {
			return "error!";
		}
	}
}
