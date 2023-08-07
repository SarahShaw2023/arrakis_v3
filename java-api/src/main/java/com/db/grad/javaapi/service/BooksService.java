package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
