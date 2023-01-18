package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.models.Book;
@Service
public class BookService {

	public static List<Book> list=new ArrayList();
	
	//whenever the object of BookService is created then static blocks will be executed. 
	static {
		
		list.add(new Book(2,"Advance java","Kat"));
		list.add(new Book(3,"Spring boot java","Max"));
		list.add(new Book(4,"MySql","gibsons"));
	}
	
	// Get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	//Get book by name
	public Book getBookById(int id)
	{
		Book book=null;
		book=list.stream().filter(e -> e.getId()==id).findFirst().get();
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
}
