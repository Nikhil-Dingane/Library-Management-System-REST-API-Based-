package com.example.demo.entity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("books")
public class BookController {
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		log.info("Retrieving all books.");
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{bookId}")
	public Optional<Book> getBook(@PathVariable long bookId){
		return bookService.getBook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		log.info("Adding a book.");
		return bookService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{bookId}")
	public Book updateBook(@PathVariable long bookId,@RequestBody Book book){
		book.setId(bookId);
		return bookService.updateBook(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{bookId}")
	public Optional<Book> deleteBook(@PathVariable long bookId){
		return bookService.removeBookById(bookId);
	}
}
