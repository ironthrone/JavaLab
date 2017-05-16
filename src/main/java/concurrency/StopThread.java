package concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
//    private volatile static boolean stopRequested;

        private static boolean stopRequested;
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws  InterruptedException {
        final FlagHolder flagHolder = new FlagHolder();
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!flagHolder.stopRequested)
                    i++;
                System.out.println("Stopped");
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        flagHolder.stopRequested = true;
    }

    static class FlagHolder {
        volatile boolean stopRequested;

    }
}


