package com.example.files;

import java.io.Serializable;
import java.util.Arrays;

public class Question implements Serializable {
    public String question;
    public String[] answers;
    public int answerIndex;
    public int type  = -1;

    @Override
    public String toString() {
        return "Question [question=" + question + ", answers="
                + Arrays.toString(answers) + ", answerIndex=" + answerIndex
                + "]";
    }

}
