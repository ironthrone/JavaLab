package rxjava;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/31.
 */
public class SchedulerTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(new Task1(), 0, 5, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Task2(), 0, 10, TimeUnit.SECONDS);
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            System.out.println("task1:" +new Date().toString());
        }
    }
    static class Task2 implements Runnable {
        @Override
        public void run() {
            System.out.println("task2: " + new Date().toString());
        }
    }

}
