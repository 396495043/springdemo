/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class TempTest {
    public static final String SIMPLEDATEFORMAT_MM_SL_DD_SL_YYYY = "MM/dd/yyyy";
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(SIMPLEDATEFORMAT_MM_SL_DD_SL_YYYY);
        Date asOfDate = simpleDateFormat.parse("05/05/2020");
        System.out.println( asOfDate);

    }
}