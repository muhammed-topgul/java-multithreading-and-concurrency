package com.muhammedtopgul.examples001.synchronizedBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author muhammed-topgul
 * @since 19.12.2021 22:29
 */

public class ListWorker {

    private final Random random = new Random();

    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void run() {
        Thread thread1 = new Thread(this::fillLists);
        Thread thread2 = new Thread(this::fillLists);

        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List1: " + list1.size() + ", List2: " + list2.size());

        long end = System.currentTimeMillis();
        System.out.println("\nTime: " + (end - start));
    }

    public void fillLists() {
        for (int i = 0; i < 1_000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(1000));
        }
    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(1000));
        }
    }
}
