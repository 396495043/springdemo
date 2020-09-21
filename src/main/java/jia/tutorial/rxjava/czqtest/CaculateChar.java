/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package jia.tutorial.rxjava.czqtest;

import io.reactivex.Observable;
import jia.tutorial.rxjava.operators.TransformingTester;
import jia.tutorial.rxjava.util.MethodUtility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class CaculateChar {
    private static List<String> source =  Arrays.asList(new String[]{"aa2", "hh78kk"});

    public void doMap() {
        Observable.fromIterable(source).map(CaculateChar::caculate).subscribe(System.out::println);
    }

    public static void main(String args[]) {
        MethodUtility.invokeRunnable(CaculateChar.class);
    }

    public static String caculate(String str){
        int count=0;//计数器
        char []a=str.toUpperCase().toCharArray();
        for(int i=0;i<a.length;i++) {
            if(a[i] >= 'A' && a[i] <= 'Z') {
                count++;
            }
        }
        return str + " : "+count ;
    }
}