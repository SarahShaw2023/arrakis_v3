package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class BondsService {

    private final static int MS_IN_DAY = 86400000;

    private BondsRepository bondsRepository;

    @Autowired
    public BondsService(BondsRepository bondsRepository) {
        this.bondsRepository = bondsRepository;
    }

    public List<Bond> getAllBonds() {

        return bondsRepository.findAll();
    }
    public List<Bond> getBondsByMaturity(Date date) {

        return bondsRepository.findByMaturity(date);
    }

    public Bond add(Bond bond) {

        return bondsRepository.save(bond);
    }
}
