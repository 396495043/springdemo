/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class CollectionTest {
    public static void main(String[] args) {
        Map map = Map.of("k1", "v1", "k2", "v2");
        List list = Arrays.asList(new Integer[]{1, 2, 3});
        List list2 = Arrays.asList(1, 2, 3);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(map);
    }
}