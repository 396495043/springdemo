package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteringTester {

    private static List<String> source = IntStream.range(1, 10).mapToObj(String::valueOf).collect(Collectors.toList());

    //duplicate each number by flatMap(i-> IntStream.of(i, i))
    private static List<String> duplicated = IntStream.range(1, 10).flatMap(i-> IntStream.of(i, i)).mapToObj(String::valueOf).collect(Collectors.toList());

    public void doPredicate(){

        Observable.fromIterable(source).filter(s->Integer.parseInt(s) % 2 == 0).subscribe(System.out::println);
    }

    public void doDistinct() {
        System.out.println("without distinct");
        Observable.fromIterable(duplicated).subscribe(System.out::println);

        System.out.println("with distinct");
        Observable.fromIterable(duplicated).distinct().subscribe(System.out::println);
    }

    public void doIgnoreElements() {

        System.out.println("just notify complete without sending any elements");
        Observable.fromIterable(source).ignoreElements().subscribe(()->{
            System.out.println("completed");
        });
    }

    public void doElementAt() {
        Observable.fromIterable(source).elementAt(2).subscribe(System.out::println);
    }

    public void doTake() {
        Observable.fromIterable(source).take(3).subscribe(System.out::println);
    }

    public void doSkip() {
        Observable.fromIterable(source).skip(2).subscribe(System.out::println);
    }

    public void doFirst() {
        Observable.fromIterable(source).firstOrError().subscribe();
    }

    public void doLast() {
        Observable.fromIterable(source).lastOrError().subscribe();
    }

    public void doSample() {

        Disposable disposable = Observable.interval(20, TimeUnit.MILLISECONDS)
                .sample(100, TimeUnit.MILLISECONDS).subscribe(System.out::println);

        ThreadUtility.sleepSeconds(2);

        disposable.dispose();
    }

    public void doDebounce() {

        Observable<String> obs = Observable.create(emitter->{
            int count = 10;
            while(count -- > 0) {
                emitter.onNext(String.valueOf(count));

                ThreadUtility.sleep(20L);

                //allow the 5 to be emitted
                if (count == 5) {
                    ThreadUtility.sleepSeconds(1);
                }
            }
        });

        Disposable disposable = obs.debounce(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        ThreadUtility.sleepSeconds(3);
        disposable.dispose();
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(FilteringTester.class);
    }
}
