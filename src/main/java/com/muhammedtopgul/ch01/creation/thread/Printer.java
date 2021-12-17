package com.muhammedtopgul.ch01.creation.thread;

import static com.muhammedtopgul.util.Console.printPurple;

/**
 * @author muhammed-topgul
 * @since at 18.12.2021 01:24
 */

public class Printer extends Thread {

    private final String type;
    private final String ANSI;

    public Printer(String type, String ANSI) {
        this.type = type;
        this.ANSI = ANSI;
    }

    @Override
    public void run() {
        printPurple(type + " is running...");

        for (int i = 1; i <= 10; i++) {
            System.out.println(ANSI + i + ". " + type + " is writing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printPurple(type + " is completed.");
    }
}
