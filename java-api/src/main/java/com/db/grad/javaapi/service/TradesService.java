package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.TradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradesService {
    @Autowired
    private TradesRepository tradesRepository;
    @Autowired
    private BookUsersService bookUsersService;

    public List<Trade> getAllTrades() {
        return tradesRepository.findAll();
    }

    public List<Trade> getTradesByUserID(int userID) {

        return getTradesByBookIDs(bookUsersService.getBookIDsByUserID(userID));
    }

    public List<Trade> getTradesByBookIDs(List<Integer> book_ids) {

        List<Trade> trades = new ArrayList<>();

        for(Integer book_id : book_ids)
            trades.addAll(getTradesByBookID(book_id));

        return trades;
    }

    public List<Trade> getTradesByBookID(int userID) {

        return tradesRepository.getTradesByBookID(userID);
    }
}
