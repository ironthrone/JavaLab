package rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/7.
 */
public class DelayClient {
    public static void main(String[] args) {
        Observable.from(new Integer[]{2, 3, 4, 5})
                .filter(new Func1<Integer, Boolean>() {
                    public Boolean call(Integer integer) {
                        return integer != 3;
                    }
                })
                .delay(2000, TimeUnit.MILLISECONDS, Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<Integer>() {
                    public void call(Integer integer) {
                        System.out.println(System.currentTimeMillis());
                        System.out.println(integer);

                    }
                }, new Action1<Throwable>() {
                    public void call(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
//        Observable.interval(1000, TimeUnit.MILLISECONDS)
//                .subscribe(new Subscriber<Long>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println(aLong);
//                    }
//                });


        //无效果，activeCount()的结果最小为3
        if (Thread.activeCount() >= 1) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
