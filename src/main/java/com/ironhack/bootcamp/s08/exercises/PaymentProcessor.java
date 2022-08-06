package com.ironhack.bootcamp.s08.exercises;

public class PaymentProcessor {

    public void processTaxExemptPurchase(Account buyer, Account seller, double purchaseAmount) {
        if (buyer.getBalance() < purchaseAmount) {
            throw new IllegalArgumentException("Buyer doesn't have enough moment");
        }
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("Invalid purchase amount");
        }
        buyer.setBalance(buyer.getBalance() - purchaseAmount);
        seller.setBalance(seller.getBalance() + purchaseAmount);
    }

    public void processTaxedPurchase(Account buyer, Account seller, double purchaseAmount) {
    }

    public void issueRefund(Account buyer, Account seller, double purchaseAmount, int percent) {
    }
}