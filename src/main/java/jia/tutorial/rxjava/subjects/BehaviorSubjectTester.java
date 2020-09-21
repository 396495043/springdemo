package jia.tutorial.rxjava.subjects;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectTester {

    public static void main(String args[]) {
        SubscriberFactory sf = new SubscriberFactory();
        BehaviorSubject<Integer> publisher = BehaviorSubject.createDefault(-1);

        publisher.subscribe(sf.create());

        publisher.onNext(1);
        publisher.onNext(2);

        publisher.subscribe(sf.create());

        publisher.onNext(3);
        publisher.onNext(4);
    }
}