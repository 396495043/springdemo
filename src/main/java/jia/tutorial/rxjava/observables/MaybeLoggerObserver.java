package jia.tutorial.rxjava.observables;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class MaybeLoggerObserver<E> implements MaybeObserver<E> {

    @Override
    public void onComplete() {
        System.out.println("=====onComplete===");
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("======onSubscribe====" + disposable.getClass() + " isDisposed " + disposable.isDisposed());
    }

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
