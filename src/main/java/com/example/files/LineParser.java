/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.files;

import com.google.common.io.Files;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class LineParser {
    static  ArrayList<Question> parser(String fileName) throws Exception {
        List<String> strs = Files.readLines(new File(fileName), Charset.forName("GBK"));
        Iterator iter = strs.iterator();
        ArrayList<Question> questions = new ArrayList<>();
        while (iter.hasNext()) {
            String str = iter.next().toString();
            int answerStrIndex =  str.indexOf("【");
            Question question = new Question();
            if (answerStrIndex > 0){
                question.question = str.substring(0,answerStrIndex);
                String  answerString = str.substring(answerStrIndex+1,str.length()-1);
                question.answers = answerString.split("|");
            }else{
                question.type = 1;
            }
            question.answerIndex = 1;
            questions.add(question);
        }
        return questions;

    }
}