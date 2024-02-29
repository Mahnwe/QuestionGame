package model.handlers;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Question;
import util.FileUtil;
import util.PathUtil;
import util.stringUtilTranslate.UtilStringStorage;
import view.customobject.AnswerButton;
import view.scene.MenuScene;
import view.scene.QuestionInterface;

import java.util.List;

public class AnswerHandler {

    private static int goodAnswerNumber;
    private static int badAnswerNumber;
    private static int questionsAnswered;

    public static boolean playerAnswerIsGood(Button answerButtonClicked, Question question, VBox game)
    {
        answerButtonClicked.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        QuestionInterface.soundEffectToStop = SoundManager.playMusic(PathUtil.GOOD_ANSWER_SOUND_EFFECT);
        displayAnswer(UtilStringStorage.goodAnswerLabel, question, game);
        goodAnswerNumber = incrementStat(goodAnswerNumber);
        return true;
    }

    public static boolean playerAnswerIsWrong(Button answerButtonClicked, AnswerButton answerButton1, AnswerButton answerButton2, AnswerButton answerButton3, AnswerButton answerButton4, Question question, VBox game)
    {
        QuestionInterface.soundEffectToStop = SoundManager.playMusic(PathUtil.BAD_ANSWER_SOUND_EFFECT);
        answerButtonClicked.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        showGoodAnswer(answerButton1, question); showGoodAnswer(answerButton2, question);
        showGoodAnswer(answerButton3, question); showGoodAnswer(answerButton4, question);
        displayAnswer(UtilStringStorage.badAnswerLabel, question, game);
        badAnswerNumber = incrementStat(badAnswerNumber);
        return false;
    }
    public static Button checkWhichButtonIsClicked(List<AnswerButton> answerButtonList, Button answerButtonClicked)
    {
        for (AnswerButton answerButton : answerButtonList) {
            if (answerButton.isClicked()) {
                answerButtonClicked = answerButton;
            }
        }
        return answerButtonClicked;
    }
    public static void displayAnswer(String answerLabel, Question question, VBox game)
    {
        Label goodResult = new Label(answerLabel);
        goodResult.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));
        goodResult.setTextFill(Color.GHOSTWHITE);
        goodResult.setTranslateY(260);
        goodResult.setTranslateX(580);

        Label explanation = new Label(question.getExplanation());
        explanation.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 18));
        explanation.setTextFill(Color.GHOSTWHITE);
        explanation.setTranslateY(295);
        explanation.setTranslateX(300);

        game.getChildren().add(goodResult);
        game.getChildren().add(explanation);
    }

    public static void showGoodAnswer(AnswerButton button, Question question)
    {
        String upperGoodAnswer = question.getGoodAnswer().toUpperCase();
        if(button.getText().equals(upperGoodAnswer))
        {
            button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public static void setStatsToZero()
    {
        goodAnswerNumber = 0;
        badAnswerNumber = 0;
        questionsAnswered = 0;
    }

    public static int incrementStat(int statToIncrement)
    {
        statToIncrement++;
        return statToIncrement;
    }
    public static void storeStatsInFile()
    {
        FileUtil.getGeneralSavesFile().setProperty("goodAnswerNumber", String.valueOf(goodAnswerNumber));
        FileUtil.getGeneralSavesFile().setProperty("badAnswerNumber", String.valueOf(badAnswerNumber));
        FileUtil.getGeneralSavesFile().setProperty("questionAnswered", String.valueOf(questionsAnswered));
    }

    public static void setQuestionsAnswered(int questionsAnswered) {
        AnswerHandler.questionsAnswered = questionsAnswered;
    }

    public static int getQuestionsAnswered() {
        return questionsAnswered;
    }
}
