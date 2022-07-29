package com.ironhack.bootcamp.s5.e1sol;

import java.math.BigDecimal;
import java.util.UUID;

/*
    CRUD
    create
    read
    update
    delete
 */
public class Account {
    private String name;
    private String address;
    private BigDecimal balance;
    private String accountNumber;

    public Account(){
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = new BigDecimal("0");
    }

    public Account(String name, String address, BigDecimal balance, String accountNumber) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}