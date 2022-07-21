package com.ironhack.bootcamp.s5.p1.e1;

import java.util.Date;
import java.util.List;


public interface TransactionList {
    public static final String CONST = "constante";

    Transaction getLastTransaction();
    void addTransaction(Transaction transaction);
    Transaction getTransactionByDate(Date date);
    List<Transaction> getAllTransactions();
}
