package com.ironhack.bootcamp.s11enumshashmaps.accountasmap;

/*  Accounts are most often searched by accountNumber. Create a HashMap of Accounts with the accountNumber as the key. */

import com.ironhack.bootcamp.s11enumshashmaps.Hold;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class AccountAsMapMain {

    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();

        Account a1 =  new Account("name", "address", new BigDecimal(0), "accountNumber", Hold.FRAUD);
        Account a2 =  new Account("000000001");

        accounts.put("000000001", new Account("000000001"));
        accounts.put("000000004", new Account("000000004"));
        accounts.put("000000002", new Account("000000002"));
        accounts.put("000000003", new Account("000000003"));
        accounts.put("000000005", new Account("000000005"));
        accounts.put("000000006", new Account("000000006"));


        // print account 4 balance
        System.out.println(accounts.get("000000004").getBalance().setScale(2, RoundingMode.CEILING));



        // print account 2 name
        System.out.println(accounts.get("000000002").getName());

//        for (Account account : accounts.values()) {
//            System.out.println("Name : " + account.getName() + " Balance: " + account.getBalance().setScale(2, RoundingMode.CEILING));
//        }

        for(String key: accounts.keySet()) {
            Account account = accounts.get(key);
            System.out.println("Name : " + account.getName() + " Balance: " + account.getBalance().setScale(2, RoundingMode.CEILING));
        }
    }
}
