package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.CounterpartiesService;
import com.db.grad.javaapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CounterpartiesController {
    @Autowired
    CounterpartiesService counterpartiesService;

    @GetMapping("/counterparties")
    public List<Counterparty> getAllUsers() {
        return counterpartiesService.getAllCounterparties();
    }

}
