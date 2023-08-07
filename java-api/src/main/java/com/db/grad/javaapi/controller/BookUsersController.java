package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.service.BookUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BookUsersController {

    @Autowired
    BookUsersService bookUsersService;

    @GetMapping("/bookUsers")
    public List<BookUser> getAllBookUsers() {
        return bookUsersService.getAllBookUsers();
    }
}
