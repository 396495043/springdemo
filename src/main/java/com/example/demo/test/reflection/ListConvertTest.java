/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class ListConvertTest {
    public static void main(String[] args) {
        ArrayList<Object> list =  new ArrayList<>();
        list.add("dd");
        List<String> list2 =  list.stream().map(String.class::cast).collect(Collectors.toList());
        System.out.println( list2);

        test();

    }

    private static void test() {

        ArrayList<String> list3 = new ArrayList<>();
       // ArrayList<> list4 = new ArrayList<>();//不通过

        ArrayList list2 = new ArrayList<String>(); // 允许 rawType 类型检查就是针对引用的
        list2.add("1"); //编译通过
        list2.add(1); //编译通过

        List<String> a = new ArrayList<>();
        a.add(new String());
    }
}