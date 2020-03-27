/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.anotation;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */

public class TestBean {
    private String name ;
    private int age ;
    @AnoTest(TestBean.class)
    public String getName() {
        return name;
    }
    @AnoTest2(gerName = "sss")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}