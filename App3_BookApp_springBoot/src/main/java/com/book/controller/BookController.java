package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks()
	{
      //Book book=new Book(1,"Java Basic","Gray"); dummy
		
		List<Book> book=bookService.getAllBooks();
		
		if(book.size()==0)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	//get book by id handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable ("id") int id)
	{
		Book book=bookService.getBookById(id);
		
		if(book==null)
		{
			//other ways to create object of ResponseEntity by build() method
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // server error will come use try catch 
		}
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	//create book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book newbook=null;
		try 
		{
			newbook=bookService.addBook(book);
			return new ResponseEntity<>(newbook,HttpStatus.OK);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		
		
	}
	
	//delete book by id handler
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable ("bookId") int id)
	{
		
		try 
		{
			bookService.deleteBookById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {

           e.printStackTrace();
           
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//update by id handler
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		
		try 
		{
			bookService.updateBook(book,bookId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {

           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	
	
	
}
