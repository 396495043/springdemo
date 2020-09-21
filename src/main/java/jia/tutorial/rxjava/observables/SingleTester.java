package jia.tutorial.rxjava.observables;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.concurrent.TimeUnit;

public class SingleTester {
    public static void main(String args[]) {

        //subscribe empty consumer
        Single.just("Hello").subscribe();

        //subscribe to onSuccess callback only
        Single.just("Hello").subscribe(System.out::println);

        //subscribe to full callback onSuccess, onError
        Single.just("Hello").subscribe(new SingleLoggerObserver<>());

        //test onError
        Single.error(new Exception("Unknown")).subscribe(new SingleLoggerObserver<>());

        //test async delay
        Single.just("Hello World").delay(2, TimeUnit.SECONDS).subscribe(new SingleLoggerObserver<>());
        ThreadUtility.sleepSeconds(3);

        //use subscribeWith to get chained observer instance, perform dispose later.
        Disposable disposable = Single.just("Hello").subscribeWith(new DisposableSingleLoggerObserver<>());
        disposable.dispose();
    }
}
