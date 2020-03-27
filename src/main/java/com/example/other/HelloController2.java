/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.other;

import com.example.demo.bean.User;
import com.example.demo.service.CzqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */


@RestController
public class HelloController2 {
   @Autowired
    private CzqService czqService ;
    @RequestMapping("/json")
    public User index() {
        User user = new User();
        return user ;
    }
}