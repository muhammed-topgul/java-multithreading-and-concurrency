package com.muhammedtopgul.examples001.creation.runnable;

import static com.muhammedtopgul.util.Console.*;

/**
 * @author muhammed-topgul
 * @since 18.12.2021 01:41
 */

public class Main {

    public static void main(String[] args) {
        printRed("In Main Thread.");

        Thread thread1 = new Thread(new Printer("PDF", ANSI_BLUE));
        thread1.start();

        Thread thread2 = new Thread(new Printer("WORD", ANSI_GREEN));
        thread2.start();

        Thread thread3 = new Thread(new Printer("TXT", ANSI_YELLOW));
        thread3.start();

        printRed("In Main Thread Again.");
    }
}
