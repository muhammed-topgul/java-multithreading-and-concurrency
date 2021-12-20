package com.muhammedtopgul.examples001.producerAndConsumer.waitAndNotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static com.muhammedtopgul.util.Console.printRed;
import static com.muhammedtopgul.util.Console.printYellow;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 15:16
 */

public class ProducerConsumer {

    private final Random random = new Random();
    private final Object lock = new Object();
    private final Queue<Integer> queue = new LinkedList<>();
    private final int limit = 10;

    public void produce() {
        while (true) {
            try {
                Thread.sleep(1000);

                synchronized (lock) {
                    if (queue.size() == limit) {
                        lock.wait();
                    }

                    int value = random.nextInt(100);

                    queue.offer(random.nextInt(100));
                    printYellow("Producer produced: " + value + ", Size: " + queue.size());

                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        while (true) {
            try {
                Thread.sleep(2000);

                synchronized (lock) {
                    if (queue.size() == 0) {
                        lock.wait();
                    }

                    int value = queue.poll();
                    printRed("Consumer consumed: " + value + ", Size: " + queue.size());

                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
