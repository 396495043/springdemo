/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.jpa;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.List;

@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int s_id;
    private String s_name;

    @OneToMany(targetEntity = Library.class)

    private List books_issued;

    public List getBooks_issued() {
        return books_issued;
    }

    public void setBooks_issued(List books_issued) {
        this.books_issued = books_issued;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

}

