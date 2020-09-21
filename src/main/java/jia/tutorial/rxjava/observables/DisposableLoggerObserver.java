package jia.tutorial.rxjava.observables;

import io.reactivex.observers.DisposableObserver;

public class DisposableLoggerObserver<E> extends DisposableObserver<E> {

    @Override
    public void onNext(E e) {
        System.out.println("=====onNext===" + e);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("======onError===");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("=======onComplete===");
    }
}
