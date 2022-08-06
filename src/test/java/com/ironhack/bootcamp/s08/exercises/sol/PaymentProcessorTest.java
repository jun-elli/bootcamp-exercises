package com.ironhack.bootcamp.s08.exercises.sol;

import com.ironhack.bootcamp.s08.exercises.Account;
import com.ironhack.bootcamp.s08.exercises.sol.PaymentProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PaymentProcessorTest {

    private Account buyer;
    private Account seller;
    private PaymentProcessor paymentProcessor =  new PaymentProcessor();

    @BeforeEach
    public void setUp() {
        buyer = new Account();
        buyer.setBalance(1000);

        seller = new Account();
        seller.setBalance(1000);
    }

    // processTaxExemptPurchase tests
    @Test
    public void processTaxExemptPurchase_GoodData_Works() {
        paymentProcessor.processTaxExemptPurchase(buyer, seller, 500);
        assertEquals(500, buyer.getBalance());
        assertEquals(1500, seller.getBalance());
    }

    @Test
    public void processTaxExemptPurchase_InsufficientBuyerBalance_Throws() {
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.processTaxExemptPurchase(buyer, seller, 1500));

    }

    @Test
    public void processTaxExemptPurchase_InvalidPurchaseAmount_Throws() {
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.processTaxExemptPurchase(buyer, seller, -500));

    }

    // processTaxedPurchase tests
    @Test
    public void processTaxedPurchase_GoodData_Works() {
        paymentProcessor.processTaxedPurchase(buyer, seller, 500);
        assertEquals(430, buyer.getBalance());
        assertEquals(1570, seller.getBalance());
    }

    @Test
    public void processTaxedPurchase_InsufficientBuyerBalance_Throws() {
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.processTaxedPurchase(buyer, seller, 1500));

    }

    @Test
    public void processTaxedPurchase_InvalidPurchaseAmount_Throws() {
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.processTaxedPurchase(buyer, seller, -500));

    }

    //issueRefund tests
    @Test
    public void issueRefund_GoodData_Works() {
        paymentProcessor.issueRefund(buyer, seller, 500, 60);
        assertEquals(1300, buyer.getBalance());
        assertEquals(700, seller.getBalance());
    }

    @Test
    public void issueRefund_InvalidRefundPercentage_Throws() {
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.issueRefund(buyer, seller, 1500, 150));
        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.issueRefund(buyer, seller, 1500, -25));

    }

    @Test
    public void issueRefund_InvalidRefundAmount_Throws() {

        assertThrows(IllegalArgumentException.class,() ->
                paymentProcessor.issueRefund(buyer, seller, -500, 100));

    }
}