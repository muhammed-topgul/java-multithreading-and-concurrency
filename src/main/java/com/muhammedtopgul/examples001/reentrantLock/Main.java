package com.muhammedtopgul.examples001.reentrantLock;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 16:20
 */

public class Main {

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        Thread thread1 = new Thread(reentrantLockExample::job1);
        Thread thread2 = new Thread(reentrantLockExample::job2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reentrantLockExample.threadOver();
    }
}
