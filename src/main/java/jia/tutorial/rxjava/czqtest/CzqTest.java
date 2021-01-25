/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package jia.tutorial.rxjava.czqtest;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class CzqTest {
    private static List<String> source =  Arrays.asList(new String[]{"aa2", "hh78kk"});

    public static void doMap() {
        Observable.fromIterable(source).map(CzqTest::caculate).subscribe(System.out::println);
        System.out.println(Observable.fromIterable(source).map(CzqTest::caculate).toList().blockingGet());
        Completable.fromSingle(Single.just("ss")).toMaybe().toObservable().subscribe(System.out::println);
        Single.just("ss").toCompletable().toMaybe().toObservable().subscribe(System.out::println);
        Single.just("ss").toObservable().map(CzqTest::caculate).subscribe(System.out::println);
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                observableEmitter.onNext("SS");
                Arrays.asList("Hello", "World").forEach(observableEmitter::onNext);
            }
        }).subscribe(System.out::println);
    }

    public static void doMap2() {
        Single.defer(()-> Single.just("SS"));
        Observable.defer(()->Observable.fromIterable(Arrays.asList("Hello", "World")));
        Observable<String> temp = Observable.fromIterable(Arrays.asList("Hello", "World")).map(CzqTest::caculate).flatMap(CzqTest::fm);
        System.out.println( " not sub ");
        temp.subscribe(System.out::println);

    }

    public static void doMap3() {
        Disposable disposable = Observable.timer(0, TimeUnit.SECONDS).subscribe(System.out::println);
        Observable<String> fromCallable = Observable.fromCallable(() -> new String("Hello World" + System.currentTimeMillis()));
        fromCallable.subscribe(System.out::println);
        ThreadUtility.sleepSeconds(3);
        disposable.dispose();

    }

    private static Observable<String> fm(String s) {
        System.out.println( "fm");
       return Observable.fromIterable(Arrays.asList("czq" + s , "yqm"+ s));
    }

    private static String caculate(String s) {
        System.out.println( "caculate");
        return s + "444" ;
    }

    public static void main(String args[]) {
        doMap3();
        // add test 1
        // add test 2
    }


}