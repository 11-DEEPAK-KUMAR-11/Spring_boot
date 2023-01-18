package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
		      book=list.stream().filter(e -> e.getId()==id).findFirst().get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	//add new book
	
	public Book addBook(Book newBook)
	{
		list.add(newBook);
		
		return newBook;
	}
	
	// delete book by id
	public void deleteBookById(int id)
	{
		//books id match with given id leave this book and add other book in the same list by doing so 
		//book with given id will be not there in the list----> when filter will return false which means
		//book id is not matched with given id then collect it and add to the list.
		
		list=list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
        //System.out.println("Book is deleted with id "+id);
	}

	//update book details
	public void updateBook(Book book, int bookId) 
	{
       list=list.stream().map(b ->{
    	   if(b.getId()==bookId)
    	   {
    		   b.setTitle(book.getTitle() );
    		   b.setAuthor(book.getAuthor());
    	   }
    	   return b;
       }).collect(Collectors.toList());

		
	}
	
	
	
	
	
	
	
}
