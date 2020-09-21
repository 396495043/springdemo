/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class Test {
    static class Food {}
    static class Fruit extends Food {}
    static class Apple extends Fruit {}

    public static void main(String[] args) throws IOException {
        /*
        List<? extends Fruit> fruits = new ArrayList<>();
        //不能加入任何元素
        fruits.add(new Food());     // compile error
        fruits.add(new Fruit());    // compile error
        fruits.add(new Apple());    // compile error

        //集合元素的类型，符合extends Fruit，可赋值给 变量fruits
        fruits = new ArrayList<Food>(); // compile error
        fruits = new ArrayList<Fruit>(); // compile success
        fruits = new ArrayList<Apple>(); // compile success  注1
        fruits.add(new Fruit());    // compile error
        fruits.add(new Apple());   // compile error 注2


        fruits = new ArrayList<? extends Fruit>(); // 在java中会出现 compile error: 通配符类型无法实例化

        Fruit object = fruits.get(0);    // compile success
        */

    }
}