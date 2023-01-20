package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.exception.BookException;
import com.book.models.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books=bService.getAllBooks();
		return new ResponseEntity<>(books,HttpStatus.ACCEPTED);
	}
	
    @GetMapping("/books/id")
    public ResponseEntity<Book> getBookById(@PathVariable ("id") int id) throws BookException
    {
    	Book book=bService.getBookById(id);
    	
    	return new ResponseEntity<>(book,HttpStatus.OK);
    }
	
	
    @PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookException
	{
    	Book newbook=bService.addNewBook(book);
    	
    	return new ResponseEntity<>(newbook,HttpStatus.CREATED);
	}
	
    @PutMapping
	public ResponseEntity<Book> updateBookById(@RequestBody Book book,@PathVariable ("id") int id) throws BookException
	{
		Book updatedBook=bService.updateBookById(book, id);
		
		return new ResponseEntity<>(updatedBook,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
