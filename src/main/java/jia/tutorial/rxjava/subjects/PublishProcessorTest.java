package jia.tutorial.rxjava.subjects;

import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import jia.tutorial.rxjava.backpressure.RequestLogger;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.stream.IntStream;

public class PublishProcessorTest {

    public static void main(String args[]) {
        PublishProcessor<Integer> subjectWithBP = PublishProcessor.create();

        subjectWithBP.onBackpressureBuffer().doOnRequest(RequestLogger::log)
                .observeOn(Schedulers.computation())
                .subscribe(System.out::println);

        IntStream.range(1, 10000).forEach(subjectWithBP::onNext);

        ThreadUtility.sleepSeconds(3);
    }
}
