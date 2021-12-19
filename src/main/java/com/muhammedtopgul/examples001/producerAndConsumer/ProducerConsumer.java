package com.muhammedtopgul.examples001.producerAndConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.muhammedtopgul.util.Console.printRed;
import static com.muhammedtopgul.util.Console.printYellow;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 00:47
 */

public class ProducerConsumer {

    private final Random random = new Random();
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() {
        while (true) {
            try {
                Thread.sleep(1000);

                int value = random.nextInt(100);

                queue.put(value);
                printYellow("Producer produced: " + value + ", Size: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        while (true) {
            try {
                Thread.sleep(5000);

                int value = queue.take();
                printRed("Consumer consumed: " + value + ", Size: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
