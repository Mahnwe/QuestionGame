package model;

import java.util.ArrayList;
import java.util.List;

public class Question
{
    private final String questionToAsk;
    private final String goodAnswer;
    private final String explanation;
    private final String category;

    private final ArrayList<String> answerList = new ArrayList<>();

    public Question(String category, String questionToAsk, String answerA, String answerB, String answerC, String answerD, String goodAnswer, String explanation)
    {
        this.category = category;
        this.questionToAsk = questionToAsk;
        this.goodAnswer = goodAnswer;
        this.explanation = explanation;
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

    public List<String> getAnswerList() {
        return answerList;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getCategory() {
        return category;
    }
}
