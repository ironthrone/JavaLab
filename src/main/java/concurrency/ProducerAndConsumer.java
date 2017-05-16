package concurrency;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/1/17.
 */
public class ProducerAndConsumer {
    private static class Product {
        private static int id;

        public Product() {
            id++;
        }

        @Override
        public String toString() {
            return "id: " + id;
        }
    }

    private static BlockingQueue<Product> productStore = new LinkedBlockingQueue<Product>(10);

    private static class Producer implements Runnable {

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    productStore.put(new Product());
                    Thread.sleep(100);
                }

            } catch (InterruptedException e) {
                System.out.println("leave producer");
            }
        }
    }

    private static class Consumer implements Runnable {

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Product product = productStore.take();
                    System.out.println(product);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println("leave consumer");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Producer());
        executorService.execute(new Consumer());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("leave");
        executorService.shutdownNow();
    }
}
