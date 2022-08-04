package com.ironhack.bootcamp.s11enumshashmaps;

import java.math.BigDecimal;
import java.util.Arrays;

public class Account {
    private String name;
    private String address;
    private BigDecimal balance;
    private String accountNumber;
    private Hold hold;

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

enum Hold {
    NONE,
    FRAUD,
    DELINQUENCY,
    LOST_STOLEN,
    LITIGATION_HOLD,
    FREERIDING;

    public boolean isOnHold() {
        return Arrays.asList(FRAUD, DELINQUENCY, LOST_STOLEN, LITIGATION_HOLD, FREERIDING).contains(this);
    }
}