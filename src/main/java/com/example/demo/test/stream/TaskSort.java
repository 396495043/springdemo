/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.stream;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class TaskSort {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(new Task("2020-04-06" ,"2020-02-04"));
        taskList.add(new Task(null ,"2020-04-04"));
        taskList.add(new Task("2020-04-05" ,"2020-03-04"));
        taskList.add(new Task(null ,"2020-04-09"));
        //https://stackoverflow.com/questions/36361156/null-safe-date-comparator-for-sorting-in-java-8-stream
        taskList.sort(Comparator.comparing(Task::getReceivedDate, Comparator.nullsFirst(Comparator.naturalOrder())).thenComparing(Task::getCreateTime));
        System.out.println( taskList);

        //taskList.sort(Comparator.nullsFirst(Comparator.comparing(Task::getReceivedDate)).thenComparing(Task::getCreateTime));

    }
}

