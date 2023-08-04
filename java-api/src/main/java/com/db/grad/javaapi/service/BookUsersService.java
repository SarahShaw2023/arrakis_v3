package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUsersRepository;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUsersService {
    @Autowired
    private BookUsersRepository bookUsersRepository;

    public List<BookUser> getAllBookUsers() {
        return bookUsersRepository.findAll();
    }

    List<Integer> getBookIDsByUserID(int userID) {
        return bookUsersRepository.getBookIDsByUserID(userID);
    }
}
