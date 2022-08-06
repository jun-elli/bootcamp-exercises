package com.ironhack.bootcamp.s5.e1sol;

import java.math.BigDecimal;
import java.util.*;

public class BankingImpl implements Banking{
    private Account bankAccount;
    private List<TransactionList> clients;

    /**
     * Default constructor initializes a bank with some default attribute values for the bank account
     */
    public BankingImpl() {
        this.bankAccount = new Account();
        this.bankAccount.setName("stripeClone");
        this.bankAccount.setAccountNumber(UUID.randomUUID().toString());
        this.bankAccount.setAddress("Stripe clone address");
        this.bankAccount.setBalance(new BigDecimal("1000000"));
        this.clients = new ArrayList<>();
    }

    /**
     * constructor with arguments initializes a bank with some custom attribute values for the bank account
     * @param name
     * @param accountNumber
     * @param address
     * @param balance
     */
    public BankingImpl(String name, String accountNumber, String address, BigDecimal balance) {
        this.bankAccount = new Account();
        this.bankAccount.setName(name);
        this.bankAccount.setAccountNumber(accountNumber);
        this.bankAccount.setAddress(address);
        this.bankAccount.setBalance(balance);
        this.clients = new ArrayList<>();
    }


    @Override
    public TransactionList getAccountPayments(String accountNumber) {
//        TransactionList foundClient = this.clients.stream()
//                .filter(client -> client.getAccountNumber().equals(accountNumber))
//                .findFirst()
//                .orElse(null);

        TransactionList foundClient = null;
        Iterator<TransactionList> iterator = this.clients.iterator();
        while (iterator.hasNext() && foundClient == null) {
            TransactionList client = iterator.next();
            if (client.getAccountNumber().equals(accountNumber)) {
                foundClient = client;
            }
        }
        return foundClient;
    }

    @Override
    public void registerNewClient(TransactionList client) {
        this.clients.add(client);
    }

    @Override
    public boolean recordNewPayment(BigDecimal amount, String accountNumber) {
        TransactionList client = this.getAccountPayments(accountNumber);
        // If we didn't found the client, then return false as operation failure
        if (client == null) {
            return false;
        }
        // If our bank doesn't have founds we return false as operation failure
        if (!this.hasFounds(amount)) {
            return false;
        }


        BigDecimal negativeAmount = amount.multiply(new BigDecimal(-1));
        Transaction transaction = new Transaction(this.bankAccount.getAccountNumber(), accountNumber, negativeAmount, new Date());
        this.increaseBankBalance(amount);
        client.addTransaction(transaction);

        return true;
    }

    @Override
    public boolean addFounds(BigDecimal amount, String accountNumber) {
        TransactionList client = this.getAccountPayments(accountNumber);

        Transaction transaction = new Transaction(this.bankAccount.getAccountNumber(), accountNumber, amount, new Date());
        this.decreaseBankBalance(amount);
        client.addTransaction(transaction);

        return true;
    }

    public BigDecimal getBalance() {
        return this.bankAccount.getBalance();
    }

    private boolean hasFounds(BigDecimal amount) {
        // Compare returns -1, 0, or 1 if bankAccount balance is less, equal, or greater than amount
        return this.bankAccount.getBalance().compareTo(amount) >= 0;
    }

    private void increaseBankBalance(BigDecimal amount) {
        this.bankAccount.setBalance(this.bankAccount.getBalance().add(amount));
    }

    private void decreaseBankBalance(BigDecimal amount) {
        this.bankAccount.setBalance(this.bankAccount.getBalance().subtract(amount));
    }
}
