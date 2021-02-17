package com.example.demo.entity.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookStock;
import com.example.demo.entity.service.BookStockService;

@RestController
@RequestMapping(value = "bookStocks")
public class BookStockController {
	@Autowired
	BookStockService bookStockService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<BookStock> getAllBookStock(){
		List<BookStock> bookStocksList = new ArrayList<BookStock>();
		bookStockService.getAllBookStock().forEach(bookStocksList::add);
		return bookStocksList;
	}
	
	@RequestMapping(value = "{bookId}")
	public BookStock getBookstock(@PathVariable Long bookId) {
		return bookStockService.getBookQuantity(bookId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public BookStock addBooks(@RequestBody BookStock bookStock) {
		return bookStockService.addBookQuantity(bookStock);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public BookStock addBoookQuantity(@RequestBody BookStock bookStock) {
		return bookStockService.updateBookQuantity(bookStock);
	}
	
	@RequestMapping(value = "{bookId}",method = RequestMethod.DELETE)
	public BookStock deleteStockByBookId(@PathVariable Long bookId) {
		return bookStockService.deleteBookStockByBookId(bookId);
	}
}
