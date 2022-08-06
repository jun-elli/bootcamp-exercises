package com.ironhack.bootcamp.s5.e1sol;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface TransactionList {
    public static final String CONST = "constante";

    String getAccountNumber();

    Transaction getLastTransaction();

    void addTransaction(Transaction transaction);

    Transaction getTransactionByDate(Date date);

    List<Transaction> getAllTransactions();

    BigDecimal getBalance();
}
