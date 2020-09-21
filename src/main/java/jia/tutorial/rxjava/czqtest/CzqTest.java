/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package jia.tutorial.rxjava.czqtest;

import io.reactivex.Observable;
import jia.tutorial.rxjava.util.MethodUtility;

import java.util.Arrays;
import java.util.List;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class CzqTest {
    private static List<String> source =  Arrays.asList(new String[]{"aa2", "hh78kk"});

    public static void doMap() {
        Observable.fromIterable(source).map(CzqTest::caculate).subscribe(System.out::println);
        System.out.println(Observable.fromIterable(source).map(CzqTest::caculate).toList().blockingGet());
    }

    private static String caculate(String s) {
        return s + "444" ;
    }

    public static void main(String args[]) {
        doMap();
    }


}