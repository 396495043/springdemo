package jia.tutorial.rxjava.subjects;

import io.reactivex.subjects.PublishSubject;

/**
 * Subject is by default hot
 */
public class PublishSubjectTester {

    public static void main(String args[]) {
        SubscriberFactory sf = new SubscriberFactory();
        PublishSubject<Integer> publisher = PublishSubject.create();

        publisher.subscribe(sf.create());

        publisher.onNext(1);
        publisher.onNext(2);

        publisher.subscribe(sf.create());

        publisher.onNext(3);
        publisher.onNext(4);
    }
}