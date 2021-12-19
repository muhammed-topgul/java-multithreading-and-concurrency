package com.muhammedtopgul.util;

/**
 * @author muhammed-topgul
 * @since 18.12.2021 01:21
 */

public class Console {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void printReset(String output) {
        System.out.println(ANSI_RESET + output);
    }

    public static void printBlack(String output) {
        System.out.println(ANSI_BLACK + output);
    }

    public static void printRed(String output) {
        System.out.println(ANSI_RED + output);
    }

    public static void printGreen(String output) {
        System.out.println(ANSI_GREEN + output);
    }

    public static void printBlue(String output) {
        System.out.println(ANSI_BLUE + output);
    }

    public static void printYellow(String output) {
        System.out.println(ANSI_YELLOW + output);
    }

    public static void printPurple(String output) {
        System.out.println(ANSI_PURPLE + output);
    }

    public static void printCyan(String output) {
        System.out.println(ANSI_CYAN + output);
    }
}
