package org.example;

import java.util.ArrayList;

public class GameHandler
{
   private QuestionStorage questionBank;
   private ArrayList<Question> questionList;

   private Question question;


    public GameHandler()
    {
        this.questionBank = new QuestionStorage();
        this.questionList = new ArrayList<>();
    }

    public void fiveQuestionList()
    {
        for(int i = 0; i < 5; i++)
        {
            question = questionBank.getQuestionList().get(i);
            questionList.add(question);
        }
    }

    public void tenQuestionList()
    {
        for(int i = 0; i < 10; i++)
        {
            question = questionBank.getQuestionList().get(i);
            questionList.add(question);
        }
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
