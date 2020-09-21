package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CreationTester {

    /**
     * Create the observable by explicitly emit elements in callback function.
     */
    public void byCreate() {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                Arrays.asList("Hello", "World").forEach(observableEmitter::onNext);
            }
        }).subscribe(System.out::println);

        /*
        //same impl as above with lambda
        Observable.create(emitter->{
            Arrays.asList("Hello", "World").forEach(emitter::onNext);
        }).subscribe(System.out::println);
         */

        Single.create(emitter->{
            emitter.onSuccess("Hello World");
        }).subscribe(System.out::println);
    }

    /**
     * Create observable from iterable or function
     */
    public void byFrom() {
        Observable.fromIterable(Arrays.asList("Hello World")).subscribe(System.out::println);

        Observable<String> fromCallable = Observable.fromCallable(() -> new String("Hello World" + System.currentTimeMillis()));
        fromCallable.subscribe(System.out::println);
        fromCallable.subscribe(System.out::println);

        Observable.fromArray("Hello", "World").subscribe(System.out::println);
    }

    public void byInterval() {
        Disposable disposable = Observable.interval(2, TimeUnit.SECONDS).subscribe(n->System.out.println("----interval every two seconds--- " + n));
        ThreadUtility.sleepSeconds(3);
        disposable.dispose();
    }

    public void byDefer() {
        Observable deferred = Observable.defer(()->Observable.just("Deferred Hello World" + System.currentTimeMillis()));

        deferred.subscribe(System.out::println);
        deferred.subscribe(System.out::println);

        Observable nonDeferred = Observable.just("Hello World" + System.currentTimeMillis());
        nonDeferred.subscribe(System.out::println);
        nonDeferred.subscribe(System.out::println);
    }

    public void byTimer(){
        Disposable disposable = Observable.timer(1, TimeUnit.SECONDS).subscribe(System.out::println);
        ThreadUtility.sleepSeconds(2);
        disposable.dispose();
    }

    public void byRange() {
        Observable.range(1, 10).subscribe(System.out::println);
    }

    public void byGenerate() {
        Observable.generate(()->new int[]{1, 1}, (arr, emitter)->{
            int next = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = next;

            if (next > 1000) {
                emitter.onComplete();
            }
            else {
                emitter.onNext(arr);
            }
        }).subscribe(arr->System.out.println(((int[])arr)[1]));
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(CreationTester.class);
    }
}
