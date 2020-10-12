/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.util;

import java.util.Objects;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class ObjectsTest {
    public static void main(String[] args) {
        String ss = null ;
      String newO =   Objects.requireNonNullElseGet(ss,ObjectsTest::getNew);
        System.out.println( newO);
    }

    private static String getNew() {
        return "dd" ;
    }
}