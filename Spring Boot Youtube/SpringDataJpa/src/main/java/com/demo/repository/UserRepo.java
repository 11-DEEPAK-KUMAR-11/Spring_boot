package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
