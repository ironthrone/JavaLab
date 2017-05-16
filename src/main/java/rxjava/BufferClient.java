package rxjava;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/7.
 */
public class BufferClient {
    public static void main(String[] args) {
        Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "string "+ integer;
                    }
                })
                .subscribeOn(Schedulers.io())
                .buffer(3,2)
                .delay(1000, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .observeOn(Schedulers.io())
                .subscribe(integers -> System.out.println(integers));



    }


}
