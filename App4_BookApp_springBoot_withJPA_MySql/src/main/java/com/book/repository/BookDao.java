package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.models.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

}
