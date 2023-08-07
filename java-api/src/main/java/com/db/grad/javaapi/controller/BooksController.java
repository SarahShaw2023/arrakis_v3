package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }
}
