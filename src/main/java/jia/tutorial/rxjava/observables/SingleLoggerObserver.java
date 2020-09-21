package jia.tutorial.rxjava.observables;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleLoggerObserver<E> implements SingleObserver<E> {

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
