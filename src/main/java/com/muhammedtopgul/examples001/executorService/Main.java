package com.muhammedtopgul.examples001.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 19.12.2021 23:28
 */

public class Main {
    private final Thread wakeUp = new Thread(new Student(Command.TURN_OFF_ALERT, 1));
    private final Thread makeBed = new Thread(new Student(Command.MAKE_BED, 2));
    private final Thread washFace = new Thread(new Student(Command.WASH_FACE, 3));
    private final Thread brushTeeth = new Thread(new Student(Command.BRUSH_TEETH, 4));
    private final Thread getDressed = new Thread(new Student(Command.GET_DRESS, 5));

    public static void main(String[] args) {
        Main main = new Main();
        // main.runWithoutOrder();
        // main.runWithOrder();
        main.runWithExecutorService();
    }

    public void runWithExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(wakeUp);
        executorService.submit(makeBed);
        executorService.submit(washFace);
        executorService.submit(brushTeeth);
        executorService.submit(getDressed);

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runWithoutOrder() {
        wakeUp.start();
        makeBed.start();
        washFace.start();
        brushTeeth.start();
        getDressed.start();
    }

    public void runWithOrder() {
        try {
            // 1. step
            wakeUp.start();
            makeBed.start();

            makeBed.join();

            // 2. step
            washFace.start();
            brushTeeth.start();

            washFace.join();
            brushTeeth.join();

            // 3 step
            getDressed.start();

            getDressed.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
