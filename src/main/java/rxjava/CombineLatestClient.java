package rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by Administrator on 2017/2/9.
 */
public class CombineLatestClient {

    public static void main(String[] args) {
        Observable<Integer> ints = Observable.from(new Integer[]{2, 3, 4, 5});
        Observable<String> strs = Observable.from(new String[]{"combine", "zip", "buffer"});
        Observable.combineLatest(ints, strs, new Func2<Integer, String, Object>() {
            public Object call(Integer integer, String s) {
                return integer + s;
            }
        })
                .subscribe(new Action1<Object>() {
                    public void call(Object people) {
                        System.out.println(people);
                    }
                });

    }
}
