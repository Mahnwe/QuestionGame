package model;

import java.util.ArrayList;
import java.util.Random;

public class GameHandler
{
   private final QuestionStorage questionBank;
   private final ArrayList<Question> questionList;

   private int questionCount;

    public GameHandler()
    {
        this.questionBank = new QuestionStorage();
        this.questionList = new ArrayList<>();
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

    public boolean isGameEnding()
    {
        return questionCount >= questionList.size();
    }

    public void IncreaseQuestionCount()
    {
        questionCount++;
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

    public int getQuestionCount() {
        return questionCount;
    }

}
