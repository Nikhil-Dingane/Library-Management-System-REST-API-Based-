package com.example.demo.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

}
