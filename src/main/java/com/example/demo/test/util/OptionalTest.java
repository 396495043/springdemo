/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.util;

import com.example.demo.bean.User;

import java.util.Optional;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = null ;
        // of throw  null exception
        Optional<User>  userO = Optional.ofNullable(user);
        System.out.println( userO.equals(null) ); // false

        System.out.println( userO.isEmpty() );
        System.out.println( userO.isPresent() );
    }
}