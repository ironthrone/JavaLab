package rxjava;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/4.
 */
public class ObservableClient {
    public static void main(String[] args) {


        Observable.timer(2000, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        return "item";
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
}
