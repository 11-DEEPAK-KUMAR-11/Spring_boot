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
		
		User user2=new User();
		user2.setCity("Delhi");
		user2.setName("Rajat");
		user2.setStatus("Java Programmer");
		
		List<User> userList=List.of(user,user2);
		
		            //or//
		
		// List<User> userList=new ArrayList<User>();
				
		// userList.add(user);
		// userList.add(user2);	
//		Iterable<User> result=userRepo.saveAll(userList);
//		
//		result.forEach(userPresent -> {
//			System.out.println(userPresent);
//		});
		
		System.out.println("Task done");
		
		//update 
//		Optional<User> foundUser=userRepo.findById(3);
//		User foundUserDB=foundUser.get();
//		foundUserDB.setName("Swatantra");
//		
//		userRepo.save(foundUserDB);
//		System.out.println(foundUserDB);
		
		//get data from DB
		
		List<User> itr=userRepo.findAll();
		for(User userList1:itr)
		{
			System.out.println(userList1);
		}
		
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
//		List<User> allUser=userRepo.findAll();
//		userRepo.deleteAll();
//		System.out.println("all items got deleted");

		
		//Derived Query method
		List<User> userByCity=userRepo.findByCity("Haridwar");
		for(User res:userByCity)
		System.out.println(res);
		
		User userBynameAndCity=userRepo.findByNameAndCity("Rajat","Delhi" );
		System.out.println(userBynameAndCity);
		
		List<User> startinName=userRepo.findByNameStartingWith("D");
	    for(User startList:startinName)
	    {
	    	System.out.println(startList);
	    }
		
	    System.out.println("==============================");
	    
		List<String> names=new ArrayList();
		names.add("Rahul");
		names.add("Deepak");
		names.add("Rajat");
		names.add("Swat");
		
		List<User> findNameInList=userRepo.findByNameIn(names);
		
		for(User nameList:findNameInList)
	    {
//	    	System.out.println(nameList);
	    }
		
		
		//fired query methods
		List<User> allUsers=userRepo.getAllUsers();
		System.out.println(allUsers);
		
		List<User> userStatus=userRepo.getUserByStatus("Programmer");
		System.out.println(userStatus);
		
		List<User> userStatusCity=userRepo.getUserByStatusAndCity("Programmer","Haridwar");
		System.out.println(userStatusCity);
		
		System.out.println("================================================");
		
		userRepo.getUsers().forEach(e -> System.out.println(e));
		
	}

}
