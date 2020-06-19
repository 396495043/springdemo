/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class Streams {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("2020-04-06", "2020-02-04"));
        taskList.add(new Task(null, "2020-04-04"));
        taskList.add(new Task("2020-04-05", "2020-03-04"));
        taskList.add(new Task(null, "2020-04-09"));
        taskList.forEach(Streams::setDate);
        taskList = taskList.stream().filter(Streams::filter).map(Streams::map).collect(Collectors.toList());
        System.out.println(taskList);
        map();
        filter();
        sorted();
        summary();

    }

    private static void summary() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    private static void sorted() {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    private static void filter() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    private static void map() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
    }

    private static Task map(Task task) {
        task.setCreateTime(new Date());
        return task;
    }

    private static boolean filter(Task task) {
        return (task.getReceivedDate() == null);
    }

    private static void setDate(Task task) {
        task.setCreateTime(new Date());
    }
}