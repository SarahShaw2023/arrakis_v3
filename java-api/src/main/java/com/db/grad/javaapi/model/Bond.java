package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bonds")
public class Bond {

    @Id
    private String isin;
    private int faceValue;
    private float couponPercent;
    private String cusip, bondCurrency, bondMaturity, issuerName, status, type;

    //~Handles sql JOIN logic
    //JOIN trade's bond_id ON bond's isin
    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="isin", referencedColumnName="bond_id", insertable=false, updatable=false)
    private Trade trade;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public float getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(float couponPercent) {
        this.couponPercent = couponPercent;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String getBondCurrency() {
        return bondCurrency;
    }

    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getBondMaturity() {
        return bondMaturity;
    }

    public void setBondMaturity(String bondMaturity) {
        this.bondMaturity = bondMaturity;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
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
}
