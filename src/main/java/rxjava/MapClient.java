package rxjava;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Administrator on 2017/2/13.
 */
public class MapClient {
    public static void main(String[] args) {
        Observable.from(new String[]{"flat", "concat", "single"})
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just(s,s+1,s+2);
                    }
                }).subscribe(s -> System.out.println(s));
        System.out.println();

        Observable.from(new String[]{"flat", "concat", "single"})
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + s.toUpperCase();
                    }
                })
                .subscribe(s -> System.out.println(s));
    }
}
