package jia.tutorial.rxjava.subjects;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectTester {

    public static void main(String args[]) {
        SubscriberFactory sf = new SubscriberFactory();
        ReplaySubject<Integer> publisher = ReplaySubject.create();

        publisher.subscribe(sf.create());

        publisher.onNext(1);
        publisher.onNext(2);

        publisher.subscribe(sf.create());

        publisher.onNext(3);
        publisher.onNext(4);
    }
}