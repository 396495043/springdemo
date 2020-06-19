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
public class Reflection3<T extends List> {


    public static void main(String[] args) {
        t1();
        t2();
    }

    private static void t2() {


        List<? extends Number> list = null;
        list = new ArrayList<Integer>();
        Number num1 = list.get(1);//√，取Number对象，赋给Number类型，当然符合Java规范
      //  Integer num2 = list.get(1);//×，取Number对象，想赋给Integer类型，由于可能是Double类型、Float类型等等，自然就不符合Java规范

      //  list.add(new Integer(1));//×,new一个Integer对象，因为声明写着List<? extends Number>，不能确定实例化对象的具体类型，所以不能进行插入。

    }


    private static void t1() {
        List<? super Integer> list = null;
        list = new ArrayList<Number>();
      //  Number num1 = list.get(1);//×，子类对象的引用无法赋值给兄弟类的引用
      //  Integer num2 = list.get(1);//×，父类对象的引用无法赋值给子类的引用
        list.add(1);//√,子类对象的引用可以赋值给父类对象的引用

    }

}