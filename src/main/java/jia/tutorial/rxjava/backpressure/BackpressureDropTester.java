package jia.tutorial.rxjava.backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.stream.IntStream;

public class BackpressureDropTester {

    public static void main(String args[]) {
        Flowable.create(emitter->{
            IntStream.range(1, 10000).forEach(emitter::onNext);
            emitter.onComplete();
        }, BackpressureStrategy.DROP).doOnRequest(RequestLogger::log)
                .observeOn(Schedulers.computation())
                .count()
                .subscribe(System.out::println);

        ThreadUtility.sleepSeconds(3);
    }
}
