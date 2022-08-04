package com.ironhack.bootcamp.s11enumshashmaps;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String address;
    private BigDecimal balance;
    private String accountNumber;
    private Hold hold;

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