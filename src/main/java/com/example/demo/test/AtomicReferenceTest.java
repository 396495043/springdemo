/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class AtomicReferenceTest {

   // https://www.cnblogs.com/liumy/p/11632878.html
    //https://www.jianshu.com/p/5521ae322743
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test2() {
        String initialReference = "initial value referenced";
        AtomicReference<String> atomicStringReference =
                new AtomicReference<String>(initialReference);
        initialReference.substring(2);
        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }

    private static void test1() {
        TO  initialReference = new TO();
        AtomicReference<TO> atomicStringReference =
                new AtomicReference<TO>(initialReference);
        initialReference = atomicStringReference.get();
        initialReference.setA(2);
        TO newReference = initialReference;
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }

    static  class TO  {
        int a ;

       public int getA() {
           return a;
       }

       public void setA(int a) {
           this.a = a;
       }
   }
}