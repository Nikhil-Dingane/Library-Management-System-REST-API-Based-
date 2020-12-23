package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import com.example.demo.entity.Book;
import com.example.demo.entity.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		//return this.books;
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	public Optional<Book> getBook(long bookId) {
		return bookRepository.findById(bookId);
	}
	
	public Book addBook(Book book) {
		book.setId(null);
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> removeBookById(long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		bookRepository.deleteById(bookId);
		return book;
	}
}
