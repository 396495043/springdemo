package jia.tutorial.rxjava.subjects;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Convert from cold observable to hot
 */
public class ConnectableTester {

    private static List<Integer> source = IntStream.range(1, 10)
            .mapToObj(i -> i).collect(Collectors.toList());

    public void byPublish() {
        SubscriberFactory sf = new SubscriberFactory();
        ConnectableObservable<Long> connectable = Observable.interval(10, TimeUnit.MILLISECONDS)
                .take(10).publish();

        Disposable disposable1 = connectable.subscribe(sf.create());
        connectable.connect();

        Disposable disposable2 = Observable.timer(50, TimeUnit.MILLISECONDS)
                .subscribe(t -> connectable.subscribe(sf.create()));

        ThreadUtility.sleepSeconds(1);
        disposable1.dispose();
        disposable2.dispose();
    }

    public void byReplay() {

        SubscriberFactory sf = new SubscriberFactory();
        ConnectableObservable<Long> connectable = Observable.interval(10, TimeUnit.MILLISECONDS)
                .take(10).replay();

        Disposable disposable1 = connectable.subscribe(sf.create());
        connectable.connect();

        Disposable disposable2 = Observable.timer(50, TimeUnit.MILLISECONDS)
                .subscribe(t -> connectable.subscribe(sf.create()));

        ThreadUtility.sleepSeconds(1);
        disposable1.dispose();
        disposable2.dispose();
    }

    public void autoConnect() {
        SubscriberFactory sf = new SubscriberFactory();
        Observable<Long> observable = Observable.interval(10, TimeUnit.MILLISECONDS)
                .take(10).publish().autoConnect(3);

        CompositeDisposable disposable = new CompositeDisposable(
                observable.subscribe(sf.create()),
                observable.subscribe(sf.create()),
                observable.subscribe(sf.create())
        );

        ThreadUtility.sleepSeconds(1);

        disposable.dispose();
    }

    public void byRefCount() {

        SubscriberFactory sf = new SubscriberFactory();
        Observable<Long> observable = Observable.interval(10, TimeUnit.MILLISECONDS)
                .take(10).publish().refCount();

        Disposable disposable1 = observable.subscribe(sf.create());

        ThreadUtility.sleep(50);
        Disposable disposable2 = observable.subscribe(sf.create());

        ThreadUtility.sleepSeconds(1);

        disposable1.dispose();
        disposable2.dispose();

    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(ConnectableTester.class);
    }
}