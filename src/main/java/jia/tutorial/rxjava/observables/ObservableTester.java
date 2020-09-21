package jia.tutorial.rxjava.observables;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.concurrent.TimeUnit;

public class ObservableTester {

    public static void main(String args[]) {

        //subscribe empty consumer
        Observable.just("Hello").subscribe();

        //subscribe to onNext callback only
        Observable.just("Hello").subscribe(System.out::println);

        //subscribe to full callback onNext, onError, onComplete
        Observable.just("Hello").subscribe(new LoggerObserver<>());

        //test onError
        Observable.error(new Exception("Unknown")).subscribe(new LoggerObserver<>());

        //test async delay
        Observable.just("Hello", "World").delay(2, TimeUnit.SECONDS).subscribe(new LoggerObserver<>());
        ThreadUtility.sleepSeconds(3);

        //use subscribeWith to get chained observer instance, perform dispose later.
        Disposable disposable = Observable.just("Hello").subscribeWith(new DisposableLoggerObserver<>());
        disposable.dispose();
    }
}
