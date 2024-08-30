package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> create(Map<String, Integer> accounts, String account) {
        Map<String, Integer> updatedAccounts = new HashMap<String, Integer>(accounts);

        updatedAccounts.put(account, 0);

        return updatedAccounts;
    }

    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        Map<String, Integer> updatedAccounts = new HashMap<String, Integer>(accounts);

        if (!updatedAccounts.containsKey(account)) {
            return updatedAccounts;
        }

        if (amount >= 0) {
            Integer deposito = updatedAccounts.get(account) + amount;

            updatedAccounts.put(account, deposito);

            return updatedAccounts;
        } else {
            return updatedAccounts;
        }
    }

    public static Map<String, Integer> withdrawal(Map<String, Integer> accounts, String account, int amount) {
        Map<String, Integer> updatedAccounts = new HashMap<String, Integer>(accounts);

        if (!updatedAccounts.containsKey(account)) {
            return updatedAccounts;
        }

        if (amount > 0) {

            if(updatedAccounts.get(account) == 0){
                return updatedAccounts;
            }else{
            Integer retiro = updatedAccounts.get(account) - amount;

            updatedAccounts.put(account, retiro);

            return updatedAccounts;
            }
        }
        return updatedAccounts;
    }

    public static Map<String, Integer> tranfer(Map<String, Integer> accounts, String account1, String account2, int amount) {
        Map<String, Integer> updatedAccounts = new HashMap<String, Integer>(accounts);

        if (amount > 0) {

            if (!updatedAccounts.containsKey(account1) || !updatedAccounts.containsKey(account2)) {
                return updatedAccounts;
            }

            if (updatedAccounts.get(account1) == 0) {
                return updatedAccounts;
            } else {

                Integer retiro = updatedAccounts.get(account1) - amount;

                Integer ingreso = updatedAccounts.get(account2) + retiro;

                updatedAccounts.put(account1, retiro);

                updatedAccounts.put(account2, ingreso);

            }
            return updatedAccounts;
        }

        return updatedAccounts;
    }
}