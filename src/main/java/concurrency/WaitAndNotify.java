package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/5.
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ExecutorService executorService = Executors.newFixedThreadPool(19);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    computer.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                computer.minus();
            }
        });

        executorService.shutdown();

    }

    private static class Computer{
        int i;
        public synchronized int add() throws InterruptedException {
            System.out.println("add run");
            i++;
            wait();
            System.out.println("wait first");
            wait();
            System.out.println("wait twice");
            return i;
        }


        public synchronized int minus() {
            System.out.println("minus run");
            i--;
            //notify后，wait状态的线程跳出wait状态，有资格争夺锁。但是他不释放锁，等minus执行完毕后锁被释放
            notifyAll();
            System.out.println("notify all executed");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }
    }
}
