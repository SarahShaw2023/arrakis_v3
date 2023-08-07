package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.TradeWithClient;
import com.db.grad.javaapi.repository.TradesWithClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradesWithClientsService {

    @Autowired
    private TradesWithClientsRepository tradesWithClientsRepository;

    @Autowired
    private BookUsersService bookUsersService;
    
    public List<TradeWithClient> getAllTradesWithClients() {
        return tradesWithClientsRepository.findAll();
    }


    public List<TradeWithClient> getTradesWithClientsByUserID(int userID) {

        return getTradesWithClientsByBookIDs(bookUsersService.getBookIDsByUserID(userID));
    }

    public List<TradeWithClient> getTradesWithClientsByBookIDs(List<Integer> book_ids) {

        List<TradeWithClient> trades = new ArrayList<>();

        for(Integer book_id : book_ids)
            trades.addAll(getTradesWithClientsByBookID(book_id));

        return trades;
    }

    public List<TradeWithClient> getTradesWithClientsByBookID(int userID) {

        return tradesWithClientsRepository.getTradesWithClientsByBookID(userID);
    }

}
