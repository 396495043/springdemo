/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.bean;

import com.example.demo.test.anotation.AnoTest;
import com.example.demo.test.anotation.AnoTest2;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */

public class User {
    private String name ;
    private int age ;
    public String getName() {
        return name;
    }
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