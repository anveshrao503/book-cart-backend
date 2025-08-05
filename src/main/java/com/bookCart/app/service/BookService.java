package com.bookCart.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookCart.app.model.Book;
import com.bookCart.app.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> getBooks(){
		return repo.findAll();
	}
	
	public Book saveBook(Book b) {
		return repo.save(b);
	}

}
