package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterpartiesRepository extends JpaRepository<Counterparty, Integer> {
    @Query(nativeQuery = true, value = "select * from counterparties")
    List<Book> getCounterparties();
}
