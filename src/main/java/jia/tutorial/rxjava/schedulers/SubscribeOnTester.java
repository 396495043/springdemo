package jia.tutorial.rxjava.schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.util.ThreadUtility;

public class SubscribeOnTester {
    public static void main(String args[]) {
        Observable.create(emitter->{

            System.out.println("Thread name in subscribe " + Thread.currentThread());
            emitter.onNext("");

        }).subscribeOn(Schedulers.computation())
                .subscribe(t->{
                    System.out.println("Thread name in observer " + Thread.currentThread());
                });

        ThreadUtility.sleepSeconds(1);
    }
}
