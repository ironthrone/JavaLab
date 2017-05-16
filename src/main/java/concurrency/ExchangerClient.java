package concurrency;

import java.util.concurrent.Exchanger;

/**
 * Created by Administrator on 2017/2/8.
 */
public class ExchangerClient {
    public static void main(String[] args) {
        Exchanger<String> exhanger = new Exchanger<String>();
        String hello = "Hello";
        String world = "World";
        //永远执行不完，exchanger需要在两个线程之间交换同类型的数据
        try {
            exhanger.exchange(hello);
            exhanger.exchange(world);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hello);
        System.out.println(world);
    }
}
