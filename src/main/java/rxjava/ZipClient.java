package rxjava;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by Administrator on 2017/2/9.
 */
public class ZipClient {
    public static void main(String[] args) {

        Observable<Integer> ints = Observable.from(new Integer[]{2, 3, 4, 5});
        Observable<String> strs = Observable.from(new String[]{"combine", "zip", "buffer"});
        Observable.zip(ints, strs, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer + s;
            }
        }).subscribe(people -> System.out.println(people));
    }

}
