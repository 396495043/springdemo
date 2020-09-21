package jia.tutorial.rxjava.observables;

import io.reactivex.observers.DisposableCompletableObserver;

public class DisposableCompletableLoggerObserver extends DisposableCompletableObserver {

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
