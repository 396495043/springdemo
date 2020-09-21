package jia.tutorial.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jia.tutorial.rxjava.util.MethodUtility;
import jia.tutorial.rxjava.util.ThreadUtility;

import java.util.concurrent.TimeUnit;

public class UtilityTester {

    public void byTimeout() {
        Disposable disposable = Observable.interval(2, TimeUnit.SECONDS)
                .timeout(1, TimeUnit.SECONDS)
                .subscribe();

        ThreadUtility.sleepSeconds(4);
        disposable.dispose();
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(UtilityTester.class);
    }

}
