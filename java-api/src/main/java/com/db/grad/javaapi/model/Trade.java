package com.db.grad.javaapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
//Refers to only date (and not time)
import java.sql.Date;

@Entity
@Table(name = "trades")
public class Trade {
    @Id
    private int id;
    private int book_id;
    private String bond_id;
    private int counterparty_id;
    private int quantity;
    private String currency;
    private String status;
    private String type;
    private float unit_price;
    private String trade_date;

    private String settlement_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBond_id() {
        return bond_id;
    }

    public void setBond_id(String bond_id) {
        this.bond_id = bond_id;
    }

    public int getCounterparty_id() {
        return counterparty_id;
    }

    public void setCounterparty_id(int counterparty_id) {
        this.counterparty_id = counterparty_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(String settlement_date) {
        this.settlement_date = settlement_date;
    }
}
