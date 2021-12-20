package com.muhammedtopgul.examples001.waitAndNotify;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 14:37
 */

public class Main {

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(waitAndNotify::job1);
        Thread thread2 = new Thread(waitAndNotify::job2);

        thread2.start();
        thread1.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
