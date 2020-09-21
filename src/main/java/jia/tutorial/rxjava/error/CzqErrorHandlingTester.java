package jia.tutorial.rxjava.error;

import io.reactivex.Observable;
import jia.tutorial.rxjava.util.MethodUtility;

public class CzqErrorHandlingTester {

    public void onErrorReturnItem() {
        Observable.concat(Observable.error(Exception::new), Observable.just("Next")).onErrorReturnItem("Error").subscribe(System.out::println);
    }


    public void czqonErrorReturnItem() {
        Observable.create(emitter -> {

            System.out.println("Thread name in subscribe " + Thread.currentThread());
            emitter.onNext(" DD ");
            emitter.onError(new RuntimeException());
            emitter.onNext(" CC ");


        }).onErrorResumeNext (Observable.just("a", "b", "c")).subscribe(System.out::println);
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

    public void czqonException() {
        Observable.error(Exception::new)
                .onExceptionResumeNext(Observable.error(Exception::new))
                .onExceptionResumeNext(Observable.just("a", "b", "c")).subscribe(System.out::println);
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(CzqErrorHandlingTester.class);
    }
}
