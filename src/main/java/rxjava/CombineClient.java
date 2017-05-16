package rxjava;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.Collections;

/**
 * Created by Administrator on 2017/4/27.
 */
public class CombineClient {
    public static void main(String[] args) {

        Observable
                .range(1, 10).zipWith(Collections.nCopies(15, "ss"), new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
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

        Observable
                .range(1, 10).zipWith(Observable.range(1,15).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer+"";
            }
        }), new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
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
