package com.example.demo.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BookStock;

public interface BookStockRepository extends CrudRepository<BookStock, Long>{
	public BookStock findByBookId(Long bookId);
}
