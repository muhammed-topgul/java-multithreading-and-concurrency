package com.muhammedtopgul.examples001.callableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

import static com.muhammedtopgul.util.Console.*;

/**
 * @author muhammed-topgul
 * @since 22.12.2021 22:07
 */

public class Main {

    private final Random random = new Random();

    public static void main(String[] args) {
        Main main = new Main();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // main.withRunnable(executorService);
        main.withCallable(executorService);
    }

    public void withCallable(ExecutorService executorService) {
        Callable<Integer> callable = () -> {
            printYellow("Thread is starting...");
            int delay = random.nextInt(1000) + 2000;

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printRed("Thread is ending...");
            return delay;
        };

        Future<Integer> future = executorService.submit(callable);
        executorService.shutdown();

        try {
            printBlue("Delay: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void withRunnable(ExecutorService executorService) {
        Runnable runnable = () -> {
            printYellow("Thread is starting...");
            int delay = random.nextInt(1000) + 2000;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printRed("Thread is ending...");
        };

        executorService.submit(runnable);

        executorService.shutdown();
    }
}
