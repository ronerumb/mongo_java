package com.workmongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workmongo.domain.User;
import com.workmongo.domain.repository.UserRepository;
import com.workmongo.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cadastro nao encontrado"));
		
	}
	
}
