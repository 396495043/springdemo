/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.files;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class JsonConvert {
    public static void main(String[] args) throws Exception {
        convertFile("D:\\temp\\qu.xml");
        convertFile("D:\\temp\\s1.xml");
        convertFile("D:\\temp\\s2.xml");
        convertFile("D:\\temp\\s11.xml");

    }

    private static void convertFile(String fileName)  throws Exception {
        ArrayList<Question> questions = MyXMLParser.parser(fileName);
        writeJson(questions,fileName);
    }

    private static void writeJson(ArrayList<Question> questions, String fileName) throws Exception {
        JsonArray root = new JsonArray();
        for (Question question:questions) {
            JsonObject questionJs = new JsonObject();
            questionJs.addProperty("qes",question.question);
            questionJs.addProperty("index",question.answerIndex);
            if (question.answers  == null){
                questionJs.addProperty("type",question.question);
            }else{
                JsonArray ansArray = new JsonArray();
                for(String ans:question.answers){
                    ansArray.add(ans);
                }
                questionJs.add("answerStr",ansArray);
            }
            root.add(questionJs);
        }
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String str = gson.toJson(root) ;
        Files.write(str ,new File(fileName+"dd") , Charset.forName("GBK"));
    }
}