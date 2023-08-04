package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BondsController {

    @Autowired
    BondsService bondsService;

    @GetMapping("/bonds")
    public List<Bond> getAllBonds() {
        return bondsService.getAllBonds();
    }
    @GetMapping("/bonds/maturity")
    public List<Bond> getBondsByMaturity(@RequestParam("date") String date){
        return bondsService.getBondsByMaturity(Date.valueOf(date));
    }

}
