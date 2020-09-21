package jia.tutorial.rxjava.backpressure;

public class RequestLogger {

    public static void log(long count) {
        System.out.println("**** request " + count);
    }
}
