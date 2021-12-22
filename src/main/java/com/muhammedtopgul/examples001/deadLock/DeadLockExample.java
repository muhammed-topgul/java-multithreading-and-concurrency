package com.muhammedtopgul.examples001.deadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 21:20
 */

public class DeadLockExample {

    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void preventDeadLock(Lock lock1, Lock lock2) {
        boolean lock1Taken, lock2Taken;

        while (true) {
            lock1Taken = lock1.tryLock();
            lock2Taken = lock2.tryLock();

            if (lock1Taken && lock2Taken) {
                return;
            }

            if (lock1Taken) {
                lock1.unlock();
            }

            if (lock2Taken) {
                lock2.unlock();
            }
        }
    }

    public void job1() {
        preventDeadLock(lock1, lock2);

        for (int i = 0; i < 5000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }

        lock1.unlock();
        lock2.unlock();
    }


    public void job2() {
        preventDeadLock(lock2, lock1);

        for (int i = 0; i < 5000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }

        lock2.unlock();
        lock1.unlock();
    }

    public void threadOver() {
        System.out.println("Account from: " + account1.getBalance());
        System.out.println("Account to: " + account2.getBalance());
        System.out.println("Total: " + (account1.getBalance() + account2.getBalance()));
    }
}
