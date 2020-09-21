package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import jia.tutorial.rxjava.util.MethodUtility;

import java.util.List;

public class CombiningTester {

    private static List<String> odds = List.of("1", "3", "5", "7", "9");

    private static List<String> evens = List.of("2", "4", "6", "8");

    public void doCombineLatest(){

        Observable.combineLatest(Observable.fromIterable(odds), Observable.fromIterable(evens), ((s1, s2) -> {
                System.out.print(String.format("%s + %s = ", s1, s2));
                return Integer.parseInt(s1) + Integer.parseInt(s2);
            }
        ))
        .subscribe(System.out::println);
    }

    public void doMerge() {

        Observable.merge(Observable.fromArray(Observable.fromIterable(odds), Observable.fromIterable(evens)))
                .subscribe(System.out::println);
    }

    public void doStartWith() {

        Observable.fromIterable(odds).startWith(evens)
            .subscribe(System.out::println);
    }

    public void doJoin() {
        System.out.println("do join");

        //todo
    }

    public void doZip() {

        Observable.fromIterable(odds).zipWith(evens, (s1, s2)->Observable.fromArray(s1, s2))
                .flatMap(s->s).subscribe(System.out::println);
    }

    public void doSwitch() {

        Observable.empty().switchIfEmpty(Observable.fromArray("a", "b", "c"))
                .subscribe(System.out::println);

        Observable.fromIterable(odds).switchIfEmpty(Observable.fromArray("a", "b", "c"))
                .subscribe(System.out::println);

        Observable.fromIterable(odds).switchMap(s->{
            return Observable.just(Character.valueOf((char)(Integer.parseInt(s) + 'a')));
        }).subscribe(System.out::println);
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(CombiningTester.class);
    }
}
