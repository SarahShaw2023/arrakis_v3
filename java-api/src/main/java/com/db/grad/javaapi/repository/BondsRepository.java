package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<Bond, String>  {
    @Query(nativeQuery = true, value = "select * from bonds where isin = :isin")
    List<Bond> findByISIN(String isin);

    @Query(nativeQuery = true, value = "select * from bonds where abs(datediff(day, :date, PARSEDATETIME(concat(bond_maturity,' 00:00:00'), 'dd/MM/yyyy HH:mm:ss'))) <= 7")
    List<Bond> findByMaturity(Date date);
}