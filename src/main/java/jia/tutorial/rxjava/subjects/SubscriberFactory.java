package jia.tutorial.rxjava.subjects;

import io.reactivex.functions.Consumer;

public class SubscriberFactory {

    private int i = 0;

    public <T> Consumer<T> create() {
        int index = ++i;
        return v -> System.out.println(String.format("subscriber %d: %s", index, String.valueOf(v)));
    }
}
