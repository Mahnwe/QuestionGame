package org.example;

import java.util.ArrayList;

public class Question
{

    private int questionNumber;
    private String questionToAsk;
    private String goodAnswer;

    private ArrayList<String> answerList = new ArrayList<>();

    public Question(int questionNumber, String questionToAsk, String answerA, String answerB, String answerC, String answerD, String goodAnswer)
    {
        this.questionNumber = questionNumber;
        this.questionToAsk = questionToAsk;
        this.goodAnswer = goodAnswer;
        answerList.add(answerA);
        answerList.add(answerB);
        answerList.add(answerC);
        answerList.add(answerD);
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public String getQuestionToAsk() {
        return questionToAsk;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }
}
