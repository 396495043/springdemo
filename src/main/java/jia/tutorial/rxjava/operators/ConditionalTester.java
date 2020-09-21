package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConditionalTester {

    private static List<String> source = IntStream.range(1, 10).mapToObj(String::valueOf).collect(Collectors.toList());

    public void byAll(){

        Observable.fromIterable(source).all(s-> Integer.parseInt(s) % 2 == 0).subscribe(System.out::println);

        Observable.fromIterable(source).all(s -> s instanceof String).subscribe(System.out::println);
    }

    public void byContains() {
        Observable.fromIterable(source).contains("-1").subscribe(System.out::println);

        Observable.fromIterable(source).contains("9").subscribe(System.out::println);
    }

    public void byDefaultIfEmpty() {
        Observable.empty().defaultIfEmpty("Hello").subscribe(System.out::println);
    }

    public void bySequenceEqual() {
        Observable.sequenceEqual(Observable.fromIterable(source),
                Observable.fromIterable(source).delay(2, TimeUnit.SECONDS))
                .subscribe(System.out::println);
        ThreadUtility.sleepSeconds(3);
    }

    public void bySkipUntil() {

        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS).take(6)
                .skipUntil(Observable.just("a").delay(4, TimeUnit.SECONDS))
                .subscribe(System.out::println);

        ThreadUtility.sleepSeconds(7);
        disposable.dispose();
    }

    public void bySkipWhile() {

        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS).take(6)
                .skipWhile((i -> i <= 3))
                .subscribe(System.out::println);

        ThreadUtility.sleepSeconds(7);
        disposable.dispose();
    }

    public void byTakeUntil(){

        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS).takeUntil(
                Observable.just(10).delay(2, TimeUnit.SECONDS)
        ).subscribe(System.out::println);

        ThreadUtility.sleepSeconds(5);
        disposable.dispose();
    }

    public void byTakeWhile() {

        Observable.fromIterable(source).takeWhile(s->Integer.parseInt(s) < 5)
                .subscribe(System.out::println);
    }

    public void byAmb() {
        Observable.amb(List.of(Observable.fromIterable(source).delay(3, TimeUnit.SECONDS),
                Observable.just("a", "b", "c"))).subscribe(System.out::println);
    }

    public static void main(String args[]) {

        MethodUtility.invokeRunnable(ConditionalTester.class);
    }
}