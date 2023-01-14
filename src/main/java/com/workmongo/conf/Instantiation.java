package com.workmongo.conf;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workmongo.domain.Post;
import com.workmongo.domain.User;
import com.workmongo.domain.repository.PostRepository;
import com.workmongo.domain.repository.UserRepository;
import com.workmongo.dta.AuthorDTO;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		User joao = new User(null, "João", "joao@joao.com");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GTM"));
		
		userRepository.saveAll(Arrays.asList(maria,joao));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Vou viajar", "Abraços",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/02/2018"), "Vou viajar amanha", "boraaaaaaa",new AuthorDTO(joao));
		
	
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().add(post1);
		userRepository.save(maria);
		
		
	}

}
