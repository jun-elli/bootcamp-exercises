package com.ironhack.bootcamp.s5.e1sol;

import java.math.BigDecimal;

/**
 * Defines the behaviour of a payment platform.
 * Each account is linked to a TransactionList, hiding which kind of transaction implementation applies for each account.
 */
public interface Banking {

    TransactionList getAccountPayments(String accountNumber);

    void registerNewClient(TransactionList client);

    boolean recordNewPayment(BigDecimal amount, String accountNumber);

    boolean addFounds(BigDecimal amount, String accountNumber);
}
