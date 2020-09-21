package jia.tutorial.rxjava.error;

import io.reactivex.Observable;
import jia.tutorial.rxjava.util.MethodUtility;

public class ErrorHandlingTester {

    public void onErrorReturnItem() {
        Observable.error(Exception::new).onErrorReturnItem("Error").subscribe(System.out::println);
    }

    public void onErrorResumeNext() {
        Observable.concat(Observable.error(Exception::new), Observable.just("Next"))
                .onErrorResumeNext(Observable.just("a", "b", "c")).subscribe(System.out::println);
    }

    public void onException() {
        Observable.error(Exception::new)
                .onExceptionResumeNext(Observable.error(Error::new))
                .onExceptionResumeNext(Observable.just("a", "b", "c")).subscribe(System.out::println);
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(ErrorHandlingTester.class);
    }
}
