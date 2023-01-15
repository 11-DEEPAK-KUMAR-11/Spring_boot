package com.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
		
		//for inserting single user
		// User result=userRepo.save(user);
		// System.out.println(result);
		
		//for inserting multiple use at time
		
//		User user2=new User();
//		user2.setCity("Delhi");
//		user2.setName("Rajat");
//		user2.setStatus("Java Programmer");
//		
//		List<User> userList=List.of(user,user2);
		
		            //or//
		
		// List<User> userList=new ArrayList<User>();
				
		// userList.add(user);
		// userList.add(user2);	
//		Iterable<User> result=userRepo.saveAll(userList);
		
//		result.forEach(userPresent -> {
//			System.out.println(userPresent);
//		});
		
//		System.out.println("Task done");
		
		//update 
//		Optional<User> foundUser=userRepo.findById(3);
//		User foundUserDB=foundUser.get();
//		foundUserDB.setName("Swatantra");
//		
//		userRepo.save(foundUserDB);
//		System.out.println(foundUserDB);
		
		//get data from DB
		
//		List<User> itr=userRepo.findAll();
//		for(User userList:itr)
//		{
//			System.out.println(userList);
//		}
		
		//or
		
//		Iterable<User> itr1=userRepo.findAll();
//		Iterator<User> userIterator=itr1.iterator();
//		while(userIterator.hasNext())
//		{
//			User userListOnebyOne=userIterator.next();
//			System.out.println(userListOnebyOne);
//			
//			
//		}
		
		
		//Delete element
//		userRepo.deleteById(4);
//		System.out.println("Id 4 deleted");
		
		//delete multiple element at a time
		List<User> allUser=userRepo.findAll();
		userRepo.deleteAll();
		System.out.println("all items got deleted");
		
		
		
	}

}
