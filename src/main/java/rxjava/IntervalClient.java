package rxjava;

import rx.Observable;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/9.
 */
public class IntervalClient {
    public static void main(String[] args) {

        Observable<Long> times = Observable.interval(500, TimeUnit.MILLISECONDS, Schedulers.immediate());
        Observable<String> ops = Observable.from(new String[]{"interval", "zip", "tier"});
        Observable.zip(times, ops, new Func2<Long, String, String>() {
            @Override
            public String call(Long aLong, String s) {
                return s;
            }
        }).subscribe(s -> {
            System.out.println(s);
            System.out.println(System.currentTimeMillis());
        });
    }
}
