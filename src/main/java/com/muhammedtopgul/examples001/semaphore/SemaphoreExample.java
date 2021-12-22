package com.muhammedtopgul.examples001.semaphore;

import java.util.concurrent.Semaphore;

import static com.muhammedtopgul.util.Console.printRed;
import static com.muhammedtopgul.util.Console.printYellow;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 21:46
 */

public class SemaphoreExample {

    private Semaphore semaphore = new Semaphore(2);

    public void job(int id) {
        try {
            semaphore.acquire(id);

            printYellow("Thread - " + id);

            //Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printRed("Thread - " + id + " is ending...");

        semaphore.release();
    }
}
