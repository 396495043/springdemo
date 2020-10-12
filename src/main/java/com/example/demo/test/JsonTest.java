/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test;

import com.example.demo.bean.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class JsonTest {
    public static void main(String[] args) {
        testJsonObject();
        testJsonMarshell();
        testJsonNull();
    }

    private static void testJsonNull() {
        printNull("{}"); // null
        printNull("{\"name\":null}");  // jsonnull ,一般没有 ，但是marshall null 值的时候需要
        printNull("{\"name\":\"\"}");  // "" 和 "null" 都是 普通 字符串值
        printNull("{\"name\":\"null\"}");
    }

    private static void printNull(String str) {
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(str).getAsJsonObject(); // 不需要 cast ，以JsonElement 为中心 ，直接getAs
        JsonElement name = object.get("name");
        System.out.println(name==null?" null ":"" + name.getClass()  + " " + name.isJsonNull()  + " " + name);
    }

    private static void testJsonMarshell() {
        Gson gson = new GsonBuilder().create();
        User user = new User();
        user.setAge(5);
        String str = gson.toJson(user);
        User user2 = gson.fromJson(str, User.class);
        System.out.println(" Marshell object " + str);
        System.out.println(" UnMarshell object " + user2);
    }

    private static void testJsonObject() {
        JsonObject root = new JsonObject();
        JsonObject tom = new JsonObject();
        tom.addProperty("age" , 8);
        int [] ints = { 3,5,6};
        JsonArray tt = new JsonArray();
        tt.add(3);
        tt.add(5);
        tom.add("ints" , tt);
        root.add("tom",tom);
        JsonObject tom1 =  root.getAsJsonObject("tom");
        Number age1 = tom1.get("age").getAsNumber();
        System.out.println( " root " + root);
    }
}