package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( uniqueConstraints={ @UniqueConstraint(name="book_id_uni_const", columnNames={"book_id"})})
public class BookStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Book book;
	private int quantity;

	public BookStock() {

	}

	public BookStock(Long id, Book book, int quantity) {
		this.id = id;
		this.book = book;
		this.quantity = quantity;
	}
	
	public BookStock(Book book,int quantity) {
		this.book = book;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
}
