package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="txn_date")
    private Date txnDate;

    @JsonProperty("totalPrice")
    @Column(nullable = false)
    private BigDecimal txnPrice;

    public Long getId() {
        return id;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public BigDecimal getTxnPrice() {
        return txnPrice;
    }

    public void setTxnPrice(BigDecimal txnPrice) {
        this.txnPrice = txnPrice;
    }
}
