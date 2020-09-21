package jia.tutorial.rxjava.observables;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.stream.IntStream;

public class FlowableTester {

    public static void main(String args[]) {

        Flowable.create(emitter->{
            IntStream.range(1, 1000).forEach(emitter::onNext);
        }, BackpressureStrategy.MISSING)
                .observeOn(Schedulers.computation())
                .subscribe(System.out::println);


        ThreadUtility.sleepSeconds(3);
    }
}
