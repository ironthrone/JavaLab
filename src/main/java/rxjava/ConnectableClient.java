package rxjava;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.ConnectableObservable;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ConnectableClient {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 10);

        ConnectableObservable<Integer> published = source.publish();

        Observable<Integer> first = published;
        Observable<Integer> second = published.skip(1);
        Observable<Integer> drop = published.filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer != 6;
            }
        });

        Observable<String> both = first.zipWith(second,
                (a, b) -> a + "+" + b);

        Observable<String> all = both.zipWith(drop, new Func2<String, Integer, String>() {
            @Override
            public String call(String s, Integer integer) {
                return s + "+" + integer;
            }
        });
        all.subscribe(System.out::println);

        published.connect();
    }
}
