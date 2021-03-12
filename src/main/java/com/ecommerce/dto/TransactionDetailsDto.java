package com.ecommerce.dto;

import java.math.BigDecimal;

public class TransactionDetailsDto {

    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
