package jia.tutorial.rxjava.subjects;

import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectTester {

    public static void main(String args[]) {
        SubscriberFactory sf = new SubscriberFactory();
        AsyncSubject<Integer> publisher = AsyncSubject.create();

        publisher.subscribe(sf.create());

        publisher.onNext(1);
        publisher.onNext(2);

        publisher.subscribe(sf.create());

        publisher.onNext(3);
        publisher.onNext(4);

        // check what will happen if onComplete is not invoked.
        publisher.onComplete();
    }
}