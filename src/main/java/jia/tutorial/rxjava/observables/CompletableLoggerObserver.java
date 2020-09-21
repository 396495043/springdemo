package jia.tutorial.rxjava.observables;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class CompletableLoggerObserver implements CompletableObserver {

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("======onSubscribe====" + disposable.getClass() + " isDisposed " + disposable.isDisposed());
    }

    @Override
    public void onComplete() {
        System.out.println("=======onComplete===");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("======onError===");
        throwable.printStackTrace();
    }
}
