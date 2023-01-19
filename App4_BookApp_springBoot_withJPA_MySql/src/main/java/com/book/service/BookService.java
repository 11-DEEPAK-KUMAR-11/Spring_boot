package com.book.service;

import java.util.List;

import com.book.exception.BookException;
import com.book.models.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public Book getBookById(int id) throws BookException;
	
	public Book addNewBook(Book book) throws BookException;
	
	public Book updateBookById(Book book,int bookid) throws BookException;
	
	public Book deleteBookbyId(int bookid) throws BookException;
	
}
