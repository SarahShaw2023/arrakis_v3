package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.TradeWithClient;
import com.db.grad.javaapi.repository.TradesWithClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradesWithClientsService {

    @Autowired
    private TradesWithClientsRepository tradesWithClientsRepository;

    public List<TradeWithClient> getAllBondsWithClients() {
        return tradesWithClientsRepository.findAll();
    }
}
