package com.book.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author auther;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, Author auther) {
		super();
		this.id = id;
		this.title = title;
		this.auther = auther;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuther() {
		return auther;
	}

	public void setAuther(Author auther) {
		this.auther = auther;
	}
	
	
	
}
