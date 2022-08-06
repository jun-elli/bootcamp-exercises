package com.ironhack.bootcamp.s5.p1.s2;

public abstract class Account {

    private long accountNumber;
    private Customer owner;
    private double balance;

    //constructor, getters, and setters omitted for brevity

    abstract void processPayment(double paymentAmount);
    abstract void processDebit(double purchaseAmount);

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}