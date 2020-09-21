/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.stream;

import java.util.HashMap;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class FunctionTest {
    public static void main(String[] args) {
        new FunctionTest().hasmapTest();
    }

    private void hasmapTest() {
        HashMap hashMap = new HashMap();
        hashMap.put("5" ,"50");
        hashMap.computeIfAbsent("6" ,this::addZero);
        Object o =   hashMap.computeIfPresent("6" ,this::addZero2);
        System.out.println(  o + " dd " + hashMap);
    }

    private String addZero2(Object o, Object o1) {
        return o1 + "2";
    }

    private String addZero(Object s) {
        return s + "0";
    }
}