package com.ironhack.bootcamp.s5.p1.e1;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Create a TransactionList interface that has the methods getLastTransaction which returns a Transaction object,
 * addTransaction which is void and takes a Transaction as a parameter, getTransactionByDate which takes a Date parameter
 * and returns a Transaction object, and getAllTransactions which returns an ArrayList of Transaction objects.
 *
 * Transaction objects should have sellerAccountNumber, buyerAccountNumber,amount, and 'date properties.
 * The Account object should have name, address, accountNumber, and balance properties.
 *
 * Implement the interface in a class called PaymentList.
 * PaymentList should have an ArrayList property that contains all Transactions.
 * It should implement all methods from the interface.
 */
public class TransactionListMain {

    public static void main(String[] args) {
        PaymentList paymentList = new PaymentList();
        Transaction primeraTransaccion = new Transaction("00000001", "00000000002", new BigDecimal(2.5), new Date());
        paymentList.addTransaction(primeraTransaccion);
        paymentList.increaseLastTransactionAmount(new BigDecimal("-3.5"));

        System.out.println(paymentList.getLastTransaction().getAmount());

    }
}