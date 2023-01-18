package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.models.Book;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	//get all book handler
	@GetMapping("/books")
	public List<Book> getBooks()
	{
      //Book book=new Book(1,"Java Basic","Gray"); dummy
		
		List<Book> book=bookService.getAllBooks();
		
		
		return book;
	}
	
	//get book by id handler
	@PostMapping("/books/{id}")
	public Book getBookById(@PathVariable ("id") int id)
	{
		Book book=bookService.getBookById(id);
		
		return book;
	}
	
	//create book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book newbook=bookService.addBook(book);
		
		return newbook;
	}
	
	//delete book by id handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable ("bookId") int id)
	{
		bookService.deleteBookById(id);
		
	}
	
	//update by id handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		bookService.updateBook(book,bookId);
		return book;
	}
	
	
	
	
	
	
}
