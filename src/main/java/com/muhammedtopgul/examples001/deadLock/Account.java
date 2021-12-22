package com.muhammedtopgul.examples001.deadLock;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 21:14
 */

public class Account {

    private int balance = 1_000;

    public static void transfer(Account from, Account to, int amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
