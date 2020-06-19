/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.stream;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class Task {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date receivedDate;


    private Date createTime;


    public Task(String receivedDate, String createTime) {
        try {
            if (receivedDate != null) {
                this.receivedDate = dateFormat.parse(receivedDate);
            }
            this.createTime = dateFormat.parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return " receivedDate " + receivedDate + " createTime " + createTime;
    }
}