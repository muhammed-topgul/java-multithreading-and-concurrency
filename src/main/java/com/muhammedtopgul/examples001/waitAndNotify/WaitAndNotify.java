package com.muhammedtopgul.examples001.waitAndNotify;

import java.util.Scanner;

import static com.muhammedtopgul.util.Console.printBlue;
import static com.muhammedtopgul.util.Console.printYellow;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 14:38
 */

public class WaitAndNotify {

    private final Object lock = new Object();

    public void job1() {
        synchronized (lock) {
            printYellow("Job1 is working...");
            printYellow("Job1 is waiting...");

            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printYellow("Job1 is continuing...");
        }
    }

    public void job2() {
        Scanner scanner = new Scanner(System.in);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            printBlue("Job2 is working...");
            printBlue("Press any key to continue...");

            scanner.nextLine();

            lock.notify();

            printBlue("Job1 notified...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
