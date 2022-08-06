package com.ironhack.bootcamp.s11enumshashmaps.accountasmap;

import com.ironhack.bootcamp.s11enumshashmaps.Hold;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private String name;
    private String address;
    private BigDecimal balance;
    private String accountNumber;
    private Hold hold;

    public Account(String accountNumber) {
        this.name = UUID.randomUUID().toString();
        this.address = UUID.randomUUID().toString();
        this.balance = new BigDecimal(Math.random() * 10000000);
        this.accountNumber = accountNumber;
        this.hold = Hold.values()[Double.valueOf(Math.random() * 10).intValue() % Double.valueOf(Math.random() * 5 + 1).intValue()];
    }
    public Account(String name, String address, BigDecimal balance, String accountNumber, Hold hold) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.hold = hold;
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

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }
// constructor, getters, and setters omitted for brevity
}

/*
In your Account class from the BigDecimal activity add a Hold enum.
The Hold state should indicate if there is a reason for placing a hold on theAccount.
The potential Hold states are NONE, FRAUD, DELINQUENCY, LOST_STOLEN, LITIGATION_HOLD, FREERIDING.
 */