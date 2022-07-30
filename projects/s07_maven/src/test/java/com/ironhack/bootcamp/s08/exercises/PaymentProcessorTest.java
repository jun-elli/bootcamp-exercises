package com.ironhack.bootcamp.s08;

import com.ironhack.bootcamp.s08.exercises.Account;
import com.ironhack.bootcamp.s08.exercises.PaymentProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentProcessorTest {

    private Account buyer;
    private Account seller;
    private PaymentProcessor paymentProcessor = new PaymentProcessor();

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
    }

    @Test
    public void processTaxExemptPurchase_InsufficientBuyerBalance_Throws() {
    }

    @Test
    public void processTaxExemptPurchase_InvalidPurchaseAmount_Throws() {
    }

    // processTaxedPurchase tests
    @Test
    public void processTaxedPurchase_GoodData_Works() {
    }

    @Test
    public void processTaxedPurchase_InsufficientBuyerBalance_Throws() {

    }

    @Test
    public void processTaxedPurchase_InvalidPurchaseAmount_Throws() {

    }

    //issueRefund tests
    @Test
    public void issueRefund_GoodData_Works() {
    }

    @Test
    public void issueRefund_InvalidRefundPercentage_Throws() {

    }

    @Test
    public void issueRefund_InvalidRefundAmount_Throws() {
    }
}
