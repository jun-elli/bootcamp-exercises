package com.ironhack.bootcamp.s5.e1sol;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentList implements TransactionList {
    private List<Transaction> transactions;
    private Account account;

    public PaymentList() {
        this.transactions = new ArrayList<>();
        this.account = new Account();
    }

    public String getAccountNumber() {
        return this.account.getAccountNumber();
    }

    @Override
    public Transaction getLastTransaction() {
        return this.transactions.size() == 0 ? null : this.transactions.get(this.transactions.size()-1);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.updateAccountBalance(transaction.getAmount());
        this.transactions.add(transaction);
    }

    @Override
    public Transaction getTransactionByDate(Date date) {
        for (Transaction tx : this.transactions) {
            if (tx.getDate().equals(date)) {
                return tx;
            }
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return this.transactions;
    }

    @Override
    public BigDecimal getBalance() {
        return this.account.getBalance();
    }

    private void updateAccountBalance(BigDecimal amount) {
        BigDecimal balance = this.account.getBalance();
        this.account.setBalance(balance.add(amount));
    }
}