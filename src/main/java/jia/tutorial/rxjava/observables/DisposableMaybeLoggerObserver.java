package jia.tutorial.rxjava.observables;

import io.reactivex.observers.DisposableMaybeObserver;

public class DisposableMaybeLoggerObserver<E> extends DisposableMaybeObserver<E> {

    @Override
    public void onSuccess(E e) {
        System.out.println("=====onSuccess===" + e);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("======onError===");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("=====onComplete===");
    }
}
