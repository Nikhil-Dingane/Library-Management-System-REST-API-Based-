package com.example.demo.entity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public String getAllCourses() {
		return "Hello! You just have called REST APIS";
	}
}
