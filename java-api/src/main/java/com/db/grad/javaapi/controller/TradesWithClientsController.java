package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.TradeWithClient;
import com.db.grad.javaapi.service.TradesWithClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TradesWithClientsController {
    private TradesWithClientsService tradesWithClientsService;

    @Autowired
    public TradesWithClientsController(TradesWithClientsService bwc) {
        tradesWithClientsService = bwc;
    }

    @GetMapping("/tradesWithClients")
    public List<TradeWithClient> getTradesWithClients(){
        return tradesWithClientsService.getAllTradesWithClients();
    }

    @GetMapping("/tradesWithClients/user")
    public List<TradeWithClient> getTradesWithClientsByUser(@RequestParam("userID") int userID) {
        return tradesWithClientsService.getTradesWithClientsByUserID(userID);
    }
}
