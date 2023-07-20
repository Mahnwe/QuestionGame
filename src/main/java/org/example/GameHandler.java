package org.example;

import java.util.Scanner;

public class GameHandler
{
   private QuestionStorage questionList;

    private Question question;
    private Player player;
    private String playerAnswer;

    private String goodAnswer;

    private String returnPlayerAnswer;

    private int playerScore;

    private int questionCount = 1;
    private int questionIndex = 0;

    private Scanner scanner;

    public GameHandler(Player player)
    {
        this.questionList = new QuestionStorage();
        this.player = player;
        playerScore = player.getPlayerScore();
    }

    public void playGame()
    {
        for(int i = 0; i<questionList.getQuestionList().size(); i++ )
        {
            askQuestion();
            compareAnswer();
        }
        endGame();
    }

    public void askQuestion()
    {
        System.out.println("Ecrivez le chiffre correspondant à votre réponse");
        System.out.println("Question numéro "+questionCount);
        question = questionList.getQuestionList().get(questionIndex);
        System.out.println(question.getQuestionToAsk());
        for(int i = 0; i<question.getAnswerList().size(); i++)
        {
            System.out.println("Reponse "+ (i+1) +" : " + question.getAnswerList().get(i));
        }
        goodAnswer = question.getGoodAnswer();
        scanner = new Scanner(System.in);
        playerAnswer = scanner.next();
        System.out.println("Votre réponse est : "+playerAnswer);
    }

    public void compareAnswer()
    {
        if(playerAnswer.equals(goodAnswer))
        {
            System.out.println("Bonne réponse !");
            playerScore++;
        }
        else
        {
            System.out.println("Mauvaise réponse !");
        }
        System.out.println("Votre score est : "+playerScore);
        System.out.println("Question suivante !"+"\n");
        questionCount++;
        questionIndex++;
    }

    public void endGame()
    {
        System.out.println("Bravo vous avez répondu à toutes les questions !");
        System.out.println("Votre score final est : "+playerScore+ " réponses correctes sur "+questionIndex);
    }

    public Player getPlayer() {
        return player;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }
}
