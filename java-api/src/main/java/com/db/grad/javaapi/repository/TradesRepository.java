package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradesRepository extends JpaRepository<Trade, Integer> {
    @Query(nativeQuery = true, value = "select * from trades")
    List<Trade> getTrades();

    @Query(nativeQuery = true, value = "select * from trades as t where t.book_id = :book_id")
    List<Trade> getTradesByBookID(int book_id);
}
