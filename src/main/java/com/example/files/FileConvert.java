/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.files;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class FileConvert {
    public static final String SPLIT_1 = "\r\n";
    public static final String SPLIT_2 =  ";;";
    public static final String SPLIT_3 = "||";
    public static final String SPLIT_4 = "\r\n\r\n";

    public static void main(String[] args) throws Exception {
        convertFile("D:\\temp\\qu.xml");
        convertFile("D:\\temp\\s1.xml");
        convertFile("D:\\temp\\s2.xml");
        convertFile("D:\\temp\\s11.xml");

    }

    private static void convertFile(String fileName)  throws Exception {
        ArrayList<Question> questions = MyXMLParser.parser(fileName);
        writeData(questions,fileName);
    }

    private static void writeData(ArrayList<Question> questions, String fileName) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (Question question:questions) {
            String lin1 = ""+question.answerIndex ;
            if (question.type > 0){
                lin1 +=   SPLIT_2+  question.type ;
            }
            sb.append(lin1);
            String lin2 = "0" ;
            if (question.answers != null){
               lin2 = Joiner.on(SPLIT_2).join(question.answers);
            }
            sb.append(SPLIT_1);
            sb.append(lin2);
            sb.append(SPLIT_1);
            sb.append(question.question);
            sb.append(SPLIT_4);
        }
        Files.write(sb.toString() ,new File(fileName+"ss") , Charset.forName("GBK"));
    }


}