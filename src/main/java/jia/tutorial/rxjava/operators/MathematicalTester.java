package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import jia.tutorial.rxjava.util.MethodUtility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathematicalTester {

    private List<Integer> source = IntStream.range(1, 10).mapToObj(i->i).collect(Collectors.toList());

    public void byCount() {

        Observable.fromIterable(source).count().subscribe(System.out::println);
    }

    public void byReduce() {

        Observable.fromIterable(source).reduce((r, i)->r + i).subscribe(System.out::println);
    }

    public void byConcat() {
        Observable.concat(Observable.fromIterable(source), Observable.fromIterable(source)).count()
        .subscribe(System.out::println);
    }

    public static void main(String args[]) {

        MethodUtility.invokeRunnable(MathematicalTester.class);
    }
}