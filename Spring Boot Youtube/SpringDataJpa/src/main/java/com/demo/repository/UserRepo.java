package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public List<User> findByCity(String city);
	
	public User findByNameAndCity(String name,String city);
	
	public List<User> findByNameStartingWith(String prefix);
	
	public List<User> findByNameEndingWith(String suffix);
	
	public List<User> findByNameContaining(String word);
	
//	public List<User> findByNameByAgeGreaterThan(int age);
	
	public List<User> findByNameIn(List<String> names);
	
	public List<User> findByNameOrderByName(String names);
	
	
	//if you wants to fire query hibernate query
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	@Query("select u from User u where u.status =:n")
	public List<User> getUserByStatus(@Param ("n") String status);
	
	@Query("select u from User u where u.status =:n and city=:c")
	public List<User> getUserByStatusAndCity(@Param ("n") String status, @Param ("c") String city);
	
	//How to write native query
	@Query(value="Select * from User", nativeQuery=true)
	public List<User> getUsers();
	
	
	
	
	
	
	
}
