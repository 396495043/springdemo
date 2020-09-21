package jia.tutorial.rxjava.observables;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.concurrent.TimeUnit;

public class CompletableTester {

    static void printHello() {
        System.out.println("Hello");
    }

    public static void main(String args[]) {

        //nothing executed as there is subscriber
        Completable.fromAction(CompletableTester::printHello);

        //subscribe to make action run and complete
        Completable.fromAction(CompletableTester::printHello).subscribe();

        //subscribe to full callback onError, onComplete
        Completable.fromAction(CompletableTester::printHello).subscribe(new CompletableLoggerObserver());

        //test onError
        Completable.error(new Exception("Unknown")).subscribe(new CompletableLoggerObserver());

        //test complete
        Completable.complete().subscribe(new CompletableLoggerObserver());

        //test async delay, notice, print action is performed immediately but the complete event will be delayed 2 secs
        Completable.fromAction(CompletableTester::printHello).delay(2, TimeUnit.SECONDS).subscribe(new CompletableLoggerObserver());
        ThreadUtility.sleepSeconds(3);

        //use subscribeWith to get chained observer instance, perform dispose later.
        Disposable disposable = Completable.fromAction(CompletableTester::printHello)
                .subscribeWith(new DisposableCompletableLoggerObserver());
        disposable.dispose();
    }
}
