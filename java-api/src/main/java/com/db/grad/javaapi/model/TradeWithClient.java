package com.db.grad.javaapi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Immutable@Table(name="bondsWithClients")
public class TradeWithClient {
    //~Handles sql JOIN logic
    //JOIN trade's counterparty_id ON counterparty's id

    //Trade fields
    @Id
    @Column(insertable = false, updatable = false)
    private int id;
    private int book_id;
    private String bond_id;
    private int quantity;
    private String currency;
    private String status;
    private String type;
    private float unit_price;
    private String trade_date;

    private String settlement_date;

    //Trade fields
    private int clientId;
    private String clientName;

    public int getId() {
        return id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBond_id() {
        return bond_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public String getSettlement_date() {
        return settlement_date;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }
}
