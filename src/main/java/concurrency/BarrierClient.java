package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/6.
 */
public class BarrierClient {
    static class BarrierTask implements Runnable {

        public void run() {
            System.out.println("Reach barrier");
        }
    }

    static class WorkTask implements Runnable {
        CyclicBarrier cyclicBarrier;

        public WorkTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("do work");
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new BarrierTask());
        for (int i = 0; i < 5; i++) {
            executorService.execute(new WorkTask(cyclicBarrier));
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}
