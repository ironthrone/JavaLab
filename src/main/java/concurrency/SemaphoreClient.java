package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2017/2/8.
 */
public class SemaphoreClient {
    static class Punish implements Runnable {
        Semaphore semaphore;

        public Punish(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    //如果semaphore被用完，代码被阻塞住，tryAcquire()在拿不到旗语的时候继续往下执行
                    semaphore.acquire();
                    System.out.println(System.currentTimeMillis() + ": Punish to stand out for 2s");
                    Thread.sleep(2000);
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Punish(semaphore));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}
