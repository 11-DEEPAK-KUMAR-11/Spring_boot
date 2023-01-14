package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.repository.UserRepo;
import com.demo.user.User;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);
		UserRepo userRepo=context.getBean(UserRepo.class);
		
		User user=new User();
		user.setCity("Haridwar");
		user.setName("Deepak");
		user.setStatus("Programmer");
		
		User result=userRepo.save(user);
		System.out.println(result);
	}

}
