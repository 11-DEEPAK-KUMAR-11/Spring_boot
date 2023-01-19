package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exception.BookException;
import com.book.models.Book;
import com.book.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bDao;
	
	@Override
	public List<Book> getAllBooks() {
		
		return bDao.findAll();
	}

	@Override
	public Book getBookById(int id) throws BookException {

		Optional<Book> book=bDao.findById(id);
		Book foundBook=book.get();
		
		if(foundBook==null)
		{
			throw new BookException("Book is not available with this id "+id);
		}

		return foundBook;
	}

	@Override
	public Book addNewBook(Book book) throws BookException {

        Optional<Book> foundBook=bDao.findById(book.getId());
        Book bookExist=foundBook.get();
        
        if(bookExist!=null)
        {
        	throw new BookException("Book with this id is already exist!");
        }
        
		return bDao.save(book);
	}

	@Override
	public Book updateBookById(Book newBook,int bookid) throws BookException {

        Optional<Book> book=bDao.findById(bookid);
        Book foundBook=book.get();
        
        foundBook.setTitle(newBook.getTitle());
        foundBook.setAuther(newBook.getAuther());
        
		return foundBook;
	}

	@Override
	public Book deleteBookbyId(int bookid) throws BookException {

        Optional<Book> book=bDao.findById(bookid);
        Book foundBook=book.get();
        
        if(foundBook==null)
        {
        	throw new BookException("Book with this id is not available !");
        }
        
        bDao.deleteById(foundBook.getId());
         
		return foundBook;
	}

}
