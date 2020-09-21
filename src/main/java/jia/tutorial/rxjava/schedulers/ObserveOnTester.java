package jia.tutorial.rxjava.schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.util.ThreadUtility;

public class ObserveOnTester {

    public static void main(String args[]) {
        Observable.create(emitter->{

            System.out.println("Thread name in subscribe " + Thread.currentThread());
            emitter.onNext("");

        }).observeOn(Schedulers.computation())
        .subscribe(t->{
            System.out.println("Thread name in observe " + Thread.currentThread());
        });

        ThreadUtility.sleepSeconds(1);
    }
}
