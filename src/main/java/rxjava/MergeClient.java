package rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/2/8.
 */
public class MergeClient {
    public static void main(String[] args) {
        Observable<Integer> first = Observable.range(1, 8);
        Observable<Integer> second = Observable.range(10, 14);
        Observable.merge(first, second)
                .subscribe(new Action1<Integer>() {
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });

        Observable<Observable<Integer>> observableObservable = Observable.from((Observable<Integer>[]) new Observable[]{Observable.range(1, 14),Observable.range(18, 3)});
        Observable.merge(observableObservable,3).subscribe(new Action1<Integer>() {
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
