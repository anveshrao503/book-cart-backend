package com.bookCart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookCart.app.model.Book;
import com.bookCart.app.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "*")
public class BookCartController {
	
	@Autowired
	private BookService bookService;
	
	@Operation(summary = "Get all books", description = "Returns a list of all available books")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	@GetMapping
	public List<Book> getBooks(){
		 return bookService.getBooks();
	}
	
	@Operation(summary = "Add a new Book to catalog",description = "Adds a new book to catalog")
	@PostMapping
	public Book addBook(@Parameter(required = true,description = "Book to be added")@RequestBody Book book) {
		return bookService.saveBook(book);
	}

}
