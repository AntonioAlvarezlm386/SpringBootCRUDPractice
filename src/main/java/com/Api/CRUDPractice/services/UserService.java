package com.Api.CRUDPractice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.CRUDPractice.models.User;
import com.Api.CRUDPractice.repository.IuserRepository;

@Service
public class UserService {
	@Autowired					//inyeccion de dependencias
	IuserRepository userRepository;				//interfaz
	
	public ArrayList<User> getUsers(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	//optional puede devolver algo o null
	public Optional<User> getById(long id){
		return userRepository.findById(id);
	}
	
	
	public User updateById(User request, Long id){
		User user1 = userRepository.findById(id).get();
		user1.setFirstname(request.getFirstname());
		user1.setLastname(request.getLastname());
		user1.setEmail(request.getEmail());
		
		return user1;
	}
	
	public Boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
