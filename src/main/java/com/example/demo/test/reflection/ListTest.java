/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.test.reflection;

import java.util.ArrayList;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class ListTest extends ArrayList<ArrayList> {
    ArrayList d;
    ArrayList getFirstChildList(){
       return  get(0);
    }
}