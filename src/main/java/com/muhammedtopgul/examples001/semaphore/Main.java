package com.muhammedtopgul.examples001.semaphore;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 21:45
 */

public class Main {

    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample();

        Thread thread1 = new Thread(() -> semaphoreExample.job(1));
        Thread thread2 = new Thread(() -> semaphoreExample.job(2));
        Thread thread3 = new Thread(() -> semaphoreExample.job(3));
        Thread thread4 = new Thread(() -> semaphoreExample.job(4));
        Thread thread5 = new Thread(() -> semaphoreExample.job(5));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
