package com.workmongo.conf;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workmongo.domain.User;
import com.workmongo.domain.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		User joao = new User(null, "João", "joao@joao.com");
		userRepository.saveAll(Arrays.asList(maria,joao));
		
	}

}
