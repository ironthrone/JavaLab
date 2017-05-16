package rxjava;

import rx.Observable;
import rx.Observer;

/**
 * Created by Administrator on 2017/4/27.
 */
public class SubscribeMulti {
    //两次订阅接收到相同的数据
    public static void main(String[] args) {
        Observable observable = Observable.range(1, 10);
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("1:" +o);
            }
        });

        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("2:" +o);
            }
        });
    }
}
