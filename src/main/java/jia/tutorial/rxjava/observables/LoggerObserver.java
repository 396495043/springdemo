package jia.tutorial.rxjava.observables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoggerObserver<E> implements Observer<E>{

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("======onSubscribe====" + disposable.getClass() + " isDisposed " + disposable.isDisposed());
    }

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
