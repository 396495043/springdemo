/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.util.ArrayList;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class ListTest2<Y> extends ArrayList {
    ArrayList d;

    public static void main(String[] args) {
        ArrayList a = new ArrayList<String>();
        a.add("3");
        ArrayList<String> b = a ;
        ArrayList<CharSequence> c = a ;
        StringBuffer sb = new StringBuffer();
        sb.append("5");
        a.add(new ArrayList<String>());
        c.add(sb);
        System.out.println(  c.getClass());
        System.out.println(  c);
    }
}