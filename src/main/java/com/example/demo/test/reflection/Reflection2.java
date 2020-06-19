/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  extends , can directyly use  size .
 *
 * @author zqchen
 * @since
 */
public class Reflection2<T extends List> {
    private T t;
    public int getLength(T o){
        t = o;
        return  o.size() ;
    }

    public T getData(){
        return  t ;
    }

    public static void main(String[] args) {
        Map<String, Boolean> stateMap =  getMap();  // 不用 强制转换？
                Reflection2 r2 = new Reflection2();
        System.out.println( r2.getLength( new ArrayList()));
        System.out.println( r2.getData());
    }

    private static Map  getMap() {
       return new HashMap();
    }
}