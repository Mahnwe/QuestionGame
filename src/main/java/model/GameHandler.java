package model;

import util.QuestionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameHandler
{
   private final QuestionStorage questionBank;
   private ArrayList<Question> questionList;
   private final Random randomIndex;
   private boolean isPlayerSurvive;
   private String gameMode;

   private int questionCount;

    public GameHandler()
    {
        this.questionBank = new QuestionStorage();
        this.questionList = new ArrayList<>();
        randomIndex = new Random();
    }

    public void setupQuestionList(int listSize)
    {
        for (int i = listSize; i > 0; i--) {
            int randomQuestionIndex = generateRandomIndex();
            Question question = questionBank.getQuestionList().remove(randomQuestionIndex);
            questionList.add(question);
        }
        if(questionList.size() != listSize)
        {
            try {
                throw new QuestionException("Question list can't be create, may be Out of bounds exception, GameHandler.setupQuestionList");
            } catch (QuestionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setUpSurvivalMode()
    {
        questionList = (ArrayList<Question>) questionBank.getQuestionList();
        isPlayerSurvive = true;
        gameMode = "survival";
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

    public boolean isPlayerSurvive() {
        return isPlayerSurvive;
    }

    public String getGameMode() {
        return gameMode;
    }
}
