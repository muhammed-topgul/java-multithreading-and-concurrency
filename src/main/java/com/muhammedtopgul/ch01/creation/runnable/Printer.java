package com.muhammedtopgul.ch01.creation.runnable;

import static com.muhammedtopgul.util.Console.printPurple;
import static com.muhammedtopgul.util.Console.printReset;

/**
 * @author muhammed-topgul
 * @since at 18.12.2021 01:41
 */

public class Printer implements Runnable {

    private final String type;
    private final String ANSI;

    public Printer(String type, String ANSI) {
        this.type = type;
        this.ANSI = ANSI;
    }

    @Override
    public void run() {
        printReset(type + " is running...");

        for (int i = 1; i <= 10; i++) {
            System.out.println(ANSI + i + ". " + type + " is writing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printReset(type + " is completed.");
    }
}
