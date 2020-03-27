/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.anotation;

import java.util.Arrays;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class AnoTestMain {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(AnoTest.class.getAnnotatedInterfaces() ));
    }
}