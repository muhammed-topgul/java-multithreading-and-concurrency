package com.muhammedtopgul.examples001.producerAndConsumer;

/**
 * @author muhammed-topgul
 * @since 20.12.2021 00:46
 */

public class Main {

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(producerConsumer::produce);
        Thread consumer = new Thread(producerConsumer::consume);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
