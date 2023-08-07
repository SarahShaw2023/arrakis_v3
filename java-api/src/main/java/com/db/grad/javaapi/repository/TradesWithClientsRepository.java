package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.TradeWithClient;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="tradesWithClients")
public interface TradesWithClientsRepository extends ReadOnlyRepository<TradeWithClient, Long>{
    //Views need custom query
    @Query(nativeQuery = true, value = "select * from tradesWithClients")
    List<TradeWithClient> findAll();

    @Query(nativeQuery = true, value = "select * from trades as t where t.book_id = :book_id")
    List<TradeWithClient> getTradesWithClientsByBookID(int book_id);
}
