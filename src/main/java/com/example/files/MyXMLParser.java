/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.files;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class MyXMLParser {
    public static final String TAG = MyXMLParser.class.getSimpleName();

   static ArrayList<Question> parser(String fileName) throws Exception {
       System.out.println(" fileName " + fileName );
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(fileName));
        //获取根节点元素对象
        Element root = document.getRootElement();
        Iterator iter = root.elementIterator("event");
        ArrayList<Question> questions = new ArrayList<>();
        while (iter.hasNext()) {
            Element eventEle = (Element) iter.next();

            Question question = new Question();
            question.question = eventEle.attributeValue("lb");
            System.out.println(eventEle.asXML() );
            question.answerIndex = parserInt(eventEle.attributeValue("ai"))-1;
            String asValue = eventEle.attributeValue("as");
            if (asValue != null) {
                question.answers = asValue.split(";");
            }else{
                if (question.answerIndex  ==0){
                    question.type = 1 ;
                }else{
                    question.type = 2 ;
                }
            }
            questions.add(question);
        }
        return questions;

    }

    private static int parserInt(String ai) {
        try {
            return Integer.parseInt(ai);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0 ;
        }
    }
}