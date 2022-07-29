package com.ironhack.bootcamp.s5.e1sol;


import java.math.BigDecimal;
import java.util.Date;

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
 *
 * This implementation also has a Banking engine that handles TransactionList as clients, each transactionList is a composition
 * of a list of transactions and an account to which the transactions are aimed.
 * The banking engine could have another TransactionList implementation than PaymentList.
 */
public class TransactionListMain {

    public static void main(String[] args) {
        //Inits our banking engine
        Banking stripeClone = new BankingImpl();
        //Creates a new client
        PaymentList firstClient = new PaymentList();
        //Registers the client in our engine
        stripeClone.registerNewClient(firstClient);

        //Creates a new client
        PaymentList secondClient = new PaymentList();
        //Registers the client in our engine
        stripeClone.registerNewClient(secondClient);



        // Add founds to the clients
        stripeClone.addFounds(new BigDecimal("1000"), firstClient.getAccountNumber());
        stripeClone.addFounds(new BigDecimal("500"), secondClient.getAccountNumber());

        // first client starts paying debts
        stripeClone.recordNewPayment(new BigDecimal("100"), firstClient.getAccountNumber());
        stripeClone.recordNewPayment(new BigDecimal("100"), firstClient.getAccountNumber());

        // second client starts paying debts
        stripeClone.recordNewPayment(new BigDecimal("50"), secondClient.getAccountNumber());

        System.out.println("*first client balance*: " + firstClient.getBalance());
        System.out.println("*second client balance*: " + secondClient.getBalance());

        System.out.println("\n \t --- Bank balance: " + ((BankingImpl)stripeClone).getBalance());
    }
}