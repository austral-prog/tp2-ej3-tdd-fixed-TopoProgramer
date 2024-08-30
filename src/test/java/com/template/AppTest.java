package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.create;
import static com.template.App.deposit;
import static com.template.App.withdrawal;
import static com.template.App.tranfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AppTest {
    @Test
    void testCreate() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = create(accounts, "mate");
        assertEquals(3, updatedAccounts.size());
    }

    @Test
    void testCreate1() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = create(accounts, "bauti");
        assertEquals(3, updatedAccounts.size());
    }

    @Test
    void testCreate2() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = create(accounts, "juancru");
        assertEquals(3, updatedAccounts.size());
    }

    @Test
    void testCreate3() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = create(accounts, "augusto");
        assertEquals(3, updatedAccounts.size());
    }

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit1() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit2() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mate", 5);
        assertEquals(2, updatedAccounts.size());
    }


    @Test
    void testWithdrawal() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }

    @Test
    void testWithdrawal1() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testWithdrawal2() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mate", 5);
        assertEquals(2, updatedAccounts.size());
    }

    @Test
    void testWithdrawal3() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20,"mate",0);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mate", 5);
        assertEquals(0, updatedAccounts.get("mate"));
    }

    @Test
    void testTranfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = tranfer(accounts, "mati", "jaun", 5);
        assertEquals(25, updatedAccounts.get("jaun"));
    }
    @Test
    void testTranfer1() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20, "mate", 0, "bauti", 0);
        Map<String, Integer> updatedAccounts = tranfer(accounts, "mate", "bauti", 5);
        assertEquals(0, updatedAccounts.get("mate") + updatedAccounts.get("bauti"));
    }

    @Test
    void testTranfer2() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = tranfer(accounts, "maxi", "juancru", 5);
        assertFalse(updatedAccounts.containsKey("maxi"));
        assertFalse(updatedAccounts.containsKey("juancru"));
    }

    @Test
    void testTranfer3() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = tranfer(accounts, "mati", "jaun", -5);
        assertEquals(30, updatedAccounts.get("mati") + updatedAccounts.get("jaun"));
    }
}
