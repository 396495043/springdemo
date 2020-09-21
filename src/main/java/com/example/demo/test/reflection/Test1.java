/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/xx326664162/article/details/52175283
 *Java泛型中的PECS原则
 * @author zqchen
 * @since
 */
public class Test1 {
        static class Food {}
        static class Fruit extends Food {}
        static class Apple extends Fruit {}

        public static void main(String[] args) throws IOException {
              /*
            List<? super Fruit> fruits = new ArrayList<>();
            //Fruit 及其子类，可被看做是Fruit，从而添加成功
            fruits.add(new Food());     // compile error
            fruits.add(new Fruit());    // compile success
            fruits.add(new Apple());    // compile success

            //集合元素的类型，符合super Fruit，可赋值给变量fruits，赋值后fruits不再是逆变类型
            fruits = new ArrayList<Food>(); // compile success
            fruits = new ArrayList<Fruit>(); // compile success
            fruits = new ArrayList<Apple>(); // compile error

            fruits = new ArrayList<? super Fruit>(); // compile error: 通配符类型无法实例化

            Fruit object = fruits.get(0); // compile error，
            *
               */
        }
    }