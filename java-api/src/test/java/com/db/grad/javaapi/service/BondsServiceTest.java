package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BondsServiceTest {

    private final static int MS_IN_DAY = 86400000;

    @Mock
    private BondsRepository bondsRepository;

    @InjectMocks
    private BondsService cut;

    @Test
    public void get_bonds_by_maturity() {
//        Date currentDate = new date();
//        Bond bond;
//        bond = new Bond();
//        bond.setBondMaturity(new SimpleDateFormat("yyyy-mm-dd").format(new Date(currentDate));
//
//
//        // arrange
//
//        //act
//
//        //assert
//        assertEquals(null,actualBonds);
    }
}
