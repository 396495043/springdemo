/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test;



import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class SystemEnvironment {
    public static void main(String[] args) {
        showProperty();
        setEnv();
        showEnv();
    }

    private static void setEnv() {

        try {
            updateEnv("ttt" ,"bbb");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static void updateEnv(String name, String val) throws ReflectiveOperationException {
        // 不能真实修改 环境变量 ，但是 能修改 JVM 中的环境变量 map 。直接访问 map 的 private  field 的字段 。
        // 黑客做法 ，直接绕过去 代码限制 。修改 实现的方法中的map 。修改 第三方库 会常用到
        Map<String, String> env = System.getenv();
        Field field = env.getClass().getDeclaredField("m");  //  java.util.Collections$UnmodifiableMap 的 m field 是个 map 。
        field.setAccessible(true); // private 可以访问 。不改 会报错
        ((Map<String, String>) field.get(env)).put(name, val);
    }

    private static void showEnv() {
        Map map = System.getenv();
        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Entry entry = (Entry)it.next();
            System.out.print(entry.getKey()+"=");
            System.out.println(entry.getValue());
        }
    }

    private static void showProperty() {
        Properties properties = System.getProperties();
        Iterator it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            System.out.print(entry.getKey() + "=");
            System.out.println(entry.getValue());

        }


        // java类路径
        String javaClassPath = System.getProperty("java.class.path");
        System.out.println(javaClassPath);

       // System.setProperty("java.class.path", javaClassPath + ";D:\\");

        javaClassPath = System.getProperty("java.class.path");
        System.out.println(javaClassPath);

    }
}