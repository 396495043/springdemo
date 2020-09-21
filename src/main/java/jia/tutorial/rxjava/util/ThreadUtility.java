package jia.tutorial.rxjava.util;

public class ThreadUtility {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch(InterruptedException e){

        }
    }

    public static void sleepSeconds(long seconds) {
        sleep(seconds * 1000);
    }
}
