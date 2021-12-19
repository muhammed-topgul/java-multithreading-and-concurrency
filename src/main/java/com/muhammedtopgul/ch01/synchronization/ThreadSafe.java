package com.muhammedtopgul.ch01.synchronization;

/**
 * @author muhammed-topgul
 * @since 18.12.2021 02:07
 */

public class ThreadSafe {

    public static void main(String[] args) {
        Counter counter = new Counter(500_000);

        Thread thread1 = new Thread(() -> counter.increaseCount());
        thread1.start();
        Thread thread2 = new Thread(() -> counter.increaseCount());
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount());
    }
}
