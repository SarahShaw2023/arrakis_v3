package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.CounterpartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterpartiesService {
    @Autowired
    private CounterpartiesRepository counterpartiesRepository;

    public List<Counterparty> getAllCounterparties() {
        return counterpartiesRepository.findAll();
    }
}
