/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.jpa;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
import java.util.ArrayList;

import javax.persistence.*;



public class OneToManyExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books_issued");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Library lib1 = new Library();
        lib1.setB_id(101);
        lib1.setB_name("Data Structure");

        Library lib2 = new Library();
        lib2.setB_id(102);
        lib2.setB_name("DBMS");

        em.persist (lib1);
        em.persist (lib2);

        ArrayList<Library> list = new ArrayList<Library>();
        list.add(lib1);
        list.add(lib2);

        Student st1 = new Student();
        st1.setS_id(1);
        st1.setS_name("Maxsu");
        st1.setBooks_issued(list);

        em.persist(st1);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}

