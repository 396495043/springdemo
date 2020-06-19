/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class RegTest {
    public static void main(String[] args) {
        groupFindTest();
        replace();

    }
// group ，用 （） ，需先 find ，再用 gourp 1 ，注意 贪婪还是懒惰模式
    private static void groupFindTest() {
        String input = " testaa=[cc] testbb=[cc]  " ;
         Pattern p = Pattern.compile("\\[(.+?)\\]");
        Matcher match =  p.matcher(input);
        match.find();
        String ss = match.group(1);
        System.out.println(ss);
    }
//replace 和  replaceALL ，只有 replaceAll 才 正则。
    private static void replace() {
        String input = " testaa=[cc] testbb=[cc]  " ;
        String quote = Pattern.quote("[cc]") ;
        System.out.println(quote);
        String ss = input.replaceAll(quote, "[DD]");
        System.out.println(ss);
        ss = ss.replace("[DD]", "[D22D]");
        System.out.println(ss);
    }

}