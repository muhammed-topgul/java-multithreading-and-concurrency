package com.muhammedtopgul.examples001.executorService;

import static com.muhammedtopgul.util.Console.printBlue;
import static com.muhammedtopgul.util.Console.printYellow;

/**
 * @author muhammed-topgul
 * @since 19.12.2021 23:26
 */

public class Student implements Runnable {

    private final Command command;
    private final int taskId;

    public Student(Command command, int taskId) {
        this.command = command;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        printYellow("Student " + command + " - " + taskId + " is working...");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printBlue("Student " + command + " - " + taskId + " completed...");
    }
}
