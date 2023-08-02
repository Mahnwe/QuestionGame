package org.example;

import java.util.ArrayList;
import java.util.Random;

public class GameHandler
{
   private QuestionStorage questionBank;
   private ArrayList<Question> questionList;

    public GameHandler()
    {
        this.questionBank = new QuestionStorage();
        this.questionList = new ArrayList<>();
    }

    public void fiveQuestionList()
    {
        setupQuestionList(5);
    }

    public void tenQuestionList()
    {
        setupQuestionList(10);
    }

    public void fifteenQuestionList()
    {
        setupQuestionList(15);
    }

    public void setupQuestionList(int listSize)
    {
        for(int i = 0; i < listSize; i++)
        {
            int randomQuestionIndex = generateRandomIndex();
            Question question = questionBank.getQuestionList().remove(randomQuestionIndex);
            questionList.add(question);
        }
    }

    public int generateRandomIndex()
    {
        Random randomIndex = new Random();
        int maxRandom = questionBank.getQuestionList().size();
        int minRandom = 0;
        return randomIndex.nextInt((maxRandom - 1 - minRandom) + 1) + minRandom;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
