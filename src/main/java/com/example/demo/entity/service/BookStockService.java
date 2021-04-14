package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookStock;
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
	
	public BookStock addBookQuantity(BookStock bookStock) {
		
		return bookStockRepository.save(bookStock);
	}
	
	public BookStock updateBookQuantity(BookStock bookStock) {
		BookStock bookStock2 = getBookQuantity(bookStock.getBook().getId());
		
		if(bookStock2 != null) {
			bookStock2.setquantity(bookStock2.getquantity() + bookStock.getquantity());
			bookStock2 = bookStockRepository.save(bookStock2);
		}
		
		return bookStock2;
	}
	
	public BookStock decreaseBookQuanity(BookStock bookStock) {
		BookStock bookStock2 = getBookQuantity(bookStock.getBook().getId());
		
		if(bookStock2 != null) {
			if(bookStock2.getquantity() > 0)
			{
				bookStock2.setquantity(bookStock2.getquantity() - bookStock.getquantity());
				bookStock2 = bookStockRepository.save(bookStock2);
			} else {
				bookStock2 = null;
			}
		}
		
		return bookStock2;
	}
	
	public BookStock deleteBookStockByBookId(Long bookId) {
		BookStock bookStock = getBookQuantity(bookId);
		bookStockRepository.deleteById(bookStock.getId());
		return bookStock;
	}
}
