package com.caiopivetta6.services;

import org.springframework.stereotype.Service;

import com.caiopivetta6.model.UserModel;
import com.caiopivetta6.repositories.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public UserModel registerUser(String email, String password, String firstName, String lastName) {
		if(email == null || password == null) {
			return null;
		}else {
			UserModel userModel = new UserModel();
			userModel.setFirstName(firstName);
			userModel.setLastName(lastName);
			userModel.setLogin(email);
			userModel.setEmail(email);
			userModel.setPassword(password);
			return userRepository.save(userModel);
			
		}
	}
	
	public UserModel authenticate(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password).orElse(null);
	}
}
