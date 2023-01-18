package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.models.Book;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
      //Book book=new Book(1,"Java Basic","Gray"); dummy
		
		List<Book> book=bookService.getAllBooks();
		
		
		return book;
	}
	
	@PostMapping("/books/{id}")
	public Book getBookById(@PathVariable ("id") int id)
	{
		Book book=bookService.getBookById(id);
		
		return book;
	}
	
	
	
	
	
}
