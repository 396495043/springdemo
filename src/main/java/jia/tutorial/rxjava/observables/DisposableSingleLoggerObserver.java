package jia.tutorial.rxjava.observables;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

public class DisposableSingleLoggerObserver<E> extends DisposableSingleObserver<E> {

    @Override
    public void onSuccess(E e) {
        System.out.println("=====onSuccess===" + e);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("======onError===");
        throwable.printStackTrace();
    }
}
