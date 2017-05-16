package rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/29.
 */
public class SchedulerClient {

    public static void main(String[] args) {
//        Schedulers.io().createWorker().schedule(() -> {
//            System.out.println(Thread.currentThread());
//            System.out.println("from io");
//        });
//
        //subscribeON影响上游的doOnSubscribe
        Integer[] datas = {1,2,3};
        Observable.from(datas)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        threadInfo("map");
                        return integer + "s";
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        threadInfo("doOnSubscribe1");

                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        threadInfo("map2");
                        return s + "2s";
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        threadInfo("doOnSubscribe2");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String integer) {
                        threadInfo("onNext");
                    }
                });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void threadInfo(String info ) {
        System.out.println(info + ": " + Thread.currentThread());
    }
}
