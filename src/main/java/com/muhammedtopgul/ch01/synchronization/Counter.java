package com.muhammedtopgul.ch01.synchronization;

/**
 * @author muhammed-topgul
 * @since 18.12.2021 02:18
 */

public class Counter {

    private int count = 0;
    private int bound = 100;

    public Counter(int bound) {
        this.bound = bound;
    }

    public synchronized void increaseCount() {
        for (int i = 0; i < bound; i++) {
            count++;
        }
    }

    public synchronized void decreaseCount() {
        for (int i = 0; i < bound; i++) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
