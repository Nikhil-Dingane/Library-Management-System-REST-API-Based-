package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStock;
import com.example.demo.entity.repository.BookRepository;
import com.example.demo.entity.repository.BookStockRepository;

@Service
public class BookStockService {
	@Autowired
	BookStockRepository bookStockRepository;
	
	public List<BookStock> getAllBookStock(){
		List<BookStock> stock = new ArrayList<BookStock>();
		bookStockRepository.findAll().forEach(stock::add);
		return stock;
	}
	
	public BookStock getBookQuantity(Long bookId){
		return bookStockRepository.findByBookId(bookId);
	}
	
	public BookStock addBookQuantity(Long bookId, int quantity) {
		BookStock bookStock = new BookStock();
		Book book = new Book();
		book.setId(bookId);
		bookStock.setBook(book);
		bookStock.setquantity(quantity);
		
		return bookStockRepository.save(bookStock);
	}
}
