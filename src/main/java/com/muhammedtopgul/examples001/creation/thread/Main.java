package com.muhammedtopgul.examples001.creation.thread;

import com.muhammedtopgul.util.Console;

import static com.muhammedtopgul.util.Console.printRed;

/**
 * @author muhammed-topgul
 * @since 18.12.2021 01:28
 */

public class Main {

    public static void main(String[] args) {
        printRed("In Main Thread.");

        Thread thread1 = new Printer("PDF", Console.ANSI_BLUE);
        thread1.start();

        Thread thread2 = new Printer("WORD", Console.ANSI_GREEN);
        thread2.start();

        Thread thread3 = new Printer("TXT", Console.ANSI_YELLOW);
        thread3.start();

        printRed("In Main Thread Again.");
    }
}
