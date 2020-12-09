package com.example.demo.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.service.BookService;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/{bookId}")
	public Optional<Book> getBook(@PathVariable long bookId){
		return bookService.getBook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/books/{bookId}")
	public Book updateBook(@PathVariable long bookId,@RequestBody Book book){
		book.setId(bookId);
		return bookService.updateBook(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{bookId}")
	public Optional<Book> deleteBook(@PathVariable long bookId){
		return bookService.removeBookById(bookId);
	}
}
