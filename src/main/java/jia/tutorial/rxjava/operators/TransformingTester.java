package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import jia.tutorial.rxjava.util.MethodUtility;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransformingTester {

    private static List<String> source = IntStream.range(1, 10).mapToObj(String::valueOf).collect(Collectors.toList());

    public void doBuffer() {
        //buffer element to list
        Observable.fromIterable(source).buffer(5).subscribe(list -> System.out.println(list));

        //shorter way
        Observable.fromIterable(source).buffer(5).subscribe(System.out::println);
    }

    public void doMap() {
        Observable.fromIterable(source).map(el -> "prefix-" + el).subscribe(System.out::println);
    }

    public void doFlatMap() {

        //flat map operation transform the observable (collection of elements) to single raw element
        Observable.fromIterable(source).flatMap(el -> {
                    List<String> derivedSource = IntStream.range(1, 10).map(i -> Integer.parseInt(el) * i)
                            .mapToObj(String::valueOf).collect(Collectors.toList());
                    return Observable.fromIterable(derivedSource);
                }

        ).buffer(9).subscribe(System.out::println);
    }

    public void doScan() {
        // add each element as integer and return values for each round.
        // it perform the similar work as reduce.
        BiFunction<String, String, String> func = (acc, s) -> String.valueOf(Integer.parseInt(acc) + Integer.parseInt(s));

        Observable.fromIterable(source).scan(func)
            .subscribe(System.out::println);
    }

    public void doWindow() {

        //window buffer elements to observable to allow sync operation
        Observable.fromIterable(source).window(5).subscribe(window->{
            System.out.println(window instanceof Observable);
            window.subscribe(v->System.out.print(v + ","), e->{}, ()->System.out.println());

        });
    }

    public void doGroup() {

        // group elements by key selector function (s->Integer.parseInt(s) % 2 in this example)
        // later using collect method to accumulate the value of each group.
        // typical map reduce can be implemented using groupBy
        Observable.fromIterable(source).groupBy(s -> Integer.parseInt(s) % 2)
                .flatMap(grp->grp.collect(()-> new AtomicInteger(0), (i, s)->{
                    i.addAndGet(Integer.parseInt(s));
                }).toObservable()).subscribe(System.out::println);

    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(TransformingTester.class);
    }
}
