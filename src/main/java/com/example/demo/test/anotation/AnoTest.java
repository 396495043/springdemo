/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.anotation;

import jdk.jfr.Relational;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoTest {
    Class [] value();
}
