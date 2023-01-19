package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bService;
}
