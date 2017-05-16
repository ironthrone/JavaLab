package rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CreateObservable {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 0; i < 10; i++) {
                    subscriber.onNext("Emission_" + i);
                }
                System.out.println("Observable work on :"+Thread.currentThread());
                subscriber.onCompleted();
            }
        })
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Action1<String>() {
                    public void call(String str) {
                        System.out.println(Thread.currentThread());
                        System.out.println(str);
                    }
                }).subscribe();

        if (Thread.activeCount() >= 1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
