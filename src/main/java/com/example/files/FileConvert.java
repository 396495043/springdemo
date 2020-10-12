/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.files;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * TODO description
 *
 * @author zqchen
 * @since
 */
public class FileConvert {
    public static void main(String[] args) throws Exception {
        ArrayList<Question> questions = MyXMLParser.parser("");
        writeJson(questions);
        questions = LineParser.parser("");
        writeJson(questions);

    }

    private static void writeJson(ArrayList<Question> questions) {
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
        System.out.println( root.toString() );
    }
}