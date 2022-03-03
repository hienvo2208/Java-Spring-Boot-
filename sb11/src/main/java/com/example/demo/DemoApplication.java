package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		userRepository.findAll().forEach(System.out::println);
		// Luu user xuong database
        User user = userRepository.save(new User());
	    Long userId = user.getId();
		user.setAtk(999);
		userRepository.save(user);
		User user2 = userRepository.findById(userId).get();
		System.out.printf("User: "+user);
		System.out.printf("User2: "+user2);
        userRepository.delete(user);
		User user3 = userRepository.findById(userId).orElse(null);
		System.out.printf("User3 "+user);




	}

}
