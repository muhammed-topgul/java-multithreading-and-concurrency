package com.muhammedtopgul.examples001.reentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.muhammedtopgul.util.Console.*;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 16:18
 */

public class ReentrantLockExample {

    private int counter = 0;
    private final Lock reentrantLock = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();

    private void increase() {
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
    }

    public void job1() {
        reentrantLock.lock();

        printYellow("Job1 is waiting to be awakened...");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printYellow("Job1 awakened and its running...");
        increase();
        reentrantLock.unlock();
    }

    public void job2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        reentrantLock.lock();
        printCyan("Job2 is working...");

        increase();

        printBlue("Press any key to continue...");
        scanner.nextLine();
        condition.signal();

        reentrantLock.unlock();
    }

    public void threadOver() {
        printBlue("\nResult: " + counter);
    }
}
