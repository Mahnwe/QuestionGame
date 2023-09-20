package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameHandler
{
   private final QuestionStorage questionBank;
   private final ArrayList<Question> questionList;
   private final Random randomIndex;

   private int questionCount;

    public GameHandler()
    {
        this.questionBank = new QuestionStorage();
        this.questionList = new ArrayList<>();
        randomIndex = new Random();
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

    public void increaseQuestionCount()
    {
        questionCount++;
    }

    public int generateRandomIndex()
    {
        int maxRandom = questionBank.getQuestionList().size();
        int minRandom = 0;
        return randomIndex.nextInt((maxRandom - 1 - minRandom) + 1) + minRandom;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public int getQuestionCount() {
        return questionCount;
    }

}
