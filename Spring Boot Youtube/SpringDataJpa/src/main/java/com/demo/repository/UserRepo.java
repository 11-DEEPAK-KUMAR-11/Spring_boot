package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
	
}
