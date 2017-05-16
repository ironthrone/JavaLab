package rxjava;

import rx.Observable;
import rx.Observer;

/**
 * Created by Administrator on 2017/4/27.
 */
public class TransformClient {
    public static void main(String[] args) {

        /**
         * window根据条目数量或者间隔时间缓存条目，发送observable
         */
        Observable<Integer> observable = Observable.range(1, 100);
        observable.window(5)
                .subscribe(new Observer<Observable<Integer>>() {
                    //window发送的Observable的次序引用
                    int windowIndex = 0;
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        windowIndex++;
                        integerObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Integer integer) {
                                System.out.println(windowIndex + ": " +integer);
                            }
                        });
                    }
                });
    }
}
