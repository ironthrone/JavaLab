package rxjava;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/7.
 */
public class RepeatClient {
    public static void main(String[] args) {
        Observable.from(new String[]{"create", "from", "interval"})
                .repeat(3)
                .delay(500, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .subscribe(s -> System.out.println(s));
    }
}
