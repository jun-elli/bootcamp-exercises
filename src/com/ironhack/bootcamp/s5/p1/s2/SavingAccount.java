package com.ironhack.bootcamp.s5.p1.s2;

class SavingAccount extends Account{
    private double interestRate;

    //constructor, getters, and setters omitted for brevity

    public void processPayment(double paymentAmount){
        setBalance(getBalance() - paymentAmount);
    }

    public void processDebit(double purchaseAmount){
        setBalance(getBalance() + purchaseAmount);
    }
}
