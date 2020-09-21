package jia.tutorial.rxjava.subjects;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Explains part of difference between code and hot observables
 */
public class CodeVSHotTester {

    private static List<Integer> source = IntStream.range(1, 10).mapToObj(i->i).collect(Collectors.toList());

    public void coldObservable() {
        SubscriberFactory sf = new SubscriberFactory();
        Observable<Integer> observable = Observable.fromIterable(source);
        //.subscribeOn(Schedulers.newThread());
        observable.subscribe(sf.create());
        observable.subscribe(sf.create());

        ThreadUtility.sleepSeconds(2);
    }

    public void hotObservable() {
        SubscriberFactory sf = new SubscriberFactory();
        ConnectableObservable<Integer> observable = Observable.fromIterable(source)
                .subscribeOn(Schedulers.newThread()).publish();
        Disposable disposable1 = observable.subscribe(sf.create());
        Disposable disposable2 = observable.subscribe(sf.create());

        observable.connect();

        ThreadUtility.sleepSeconds(2);
        disposable1.dispose();
        disposable2.dispose();
    }

    public static void main(String args[]) throws InterruptedException {

        MethodUtility.invokeRunnable(CodeVSHotTester.class);
    }
}