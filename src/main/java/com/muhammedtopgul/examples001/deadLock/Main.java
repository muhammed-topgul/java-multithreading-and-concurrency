package com.muhammedtopgul.examples001.deadLock;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 21:20
 */

public class Main {

    public static void main(String[] args) {
        DeadLockExample deadLock = new DeadLockExample();

        Thread thread1 = new Thread(deadLock::job1);
        Thread thread2 = new Thread(deadLock::job2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deadLock.threadOver();
    }
}
