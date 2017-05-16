package rxjava;

import rx.Observer;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by Administrator on 2017/3/29.
 */
public class SubjectClient {
    public static void main(String[] args) {

        //没有缓存机制，它的观察者只能收到注册时刻之后的item
        PublishSubject<Integer> subject = PublishSubject.<Integer>create();
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
        subject.onNext(3);
        subject.onNext(4);

        System.out.println(ReplaySubject.class.getSimpleName());
        //缓存所有的接收到的item，每一个注册到它的Observer都能收到所有的item
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
        replaySubject.onNext(3);
        replaySubject.onNext(4);

        System.out.println(BehaviorSubject.class.getSimpleName());
        BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext(1);
        behaviorSubject.onNext(2);
        behaviorSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
        behaviorSubject.onNext(3);
        behaviorSubject.onNext(4);

        System.out.println(AsyncSubject.class.getSimpleName());
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext(1);
        asyncSubject.onNext(2);
        asyncSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
        asyncSubject.onNext(3);
        asyncSubject.onNext(4);
        asyncSubject.onCompleted();
    }
}
