package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStock;
import com.example.demo.entity.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookStockService bookStockService;
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	public Optional<Book> getBook(long bookId) {
		return bookRepository.findById(bookId);
	}
	
	public Book addBook(Book book) {
		book.setId(null);
		book = bookRepository.save(book);
		if(book != null) {
			bookStockService.addBookQuantity(new BookStock(book,1));
		}
		return book;
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> removeBookById(long bookId) {
		bookStockService.deleteBookStockByBookId(bookId);
		Optional<Book> book = bookRepository.findById(bookId);
		bookRepository.deleteById(bookId);
		return book;
	}
}
