package com.ironhack.bootcamp.s5.p1.e1;
import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private String sellerAccountNumber;
    private String buyerAccountNumber;
    private BigDecimal amount;
    private Date date;

    public Transaction() {}

    public Transaction(String sellerAccountNumber, String buyerAccountNumber, BigDecimal amount, Date date) {
        this.sellerAccountNumber = sellerAccountNumber;
        this.buyerAccountNumber = buyerAccountNumber;
        this.amount = amount;
        this.date = date;
    }

    public String getSellerAccountNumber() {
        return sellerAccountNumber;
    }

    public void setSellerAccountNumber(String sellerAccountNumber) {
        this.sellerAccountNumber = sellerAccountNumber;
    }

    public String getBuyerAccountNumber() {
        return buyerAccountNumber;
    }

    public void setBuyerAccountNumber(String buyerAccountNumber) {
        this.buyerAccountNumber = buyerAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}