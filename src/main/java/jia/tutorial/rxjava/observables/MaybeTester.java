package jia.tutorial.rxjava.observables;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.concurrent.TimeUnit;

public class MaybeTester {

    public static void main(String args[]) {

        //create observable without any elements, it will invoke onComplete callback only
        Maybe.empty().subscribe(new MaybeLoggerObserver<>());

        //subscribe empty consumer
        Maybe.just("Hello").subscribe();

        //subscribe to onSuccess callback only
        Maybe.just("Hello").subscribe(System.out::println);

        //subscribe to full callback onSuccess, onError, onComplete
        Maybe.just("Hello").subscribe(new MaybeLoggerObserver<>());

        //test onError
        Maybe.error(new Exception("Unknown")).subscribe(new MaybeLoggerObserver<>());

        //test async delay
        Maybe.just("Hello World").delay(2, TimeUnit.SECONDS).subscribe(new MaybeLoggerObserver<>());
        ThreadUtility.sleepSeconds(3);

        //use subscribeWith to get chained observer instance, perform dispose later.
        Disposable disposable = Maybe.just("Hello").subscribeWith(new DisposableMaybeLoggerObserver<>());
        disposable.dispose();
    }
}
