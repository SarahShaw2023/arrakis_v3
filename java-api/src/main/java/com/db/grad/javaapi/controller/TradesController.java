package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.BooksService;
import com.db.grad.javaapi.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TradesController {
    @Autowired
    TradesService tradesService;

    @GetMapping("/trades")
    public List<Trade> getTradesByUser(@RequestParam("userID") int userID) {
        return tradesService.getTradesByUserID(userID);
    }
}
