package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.QuestionCreatorScene;

import java.util.List;

public class ValidateQuestionCreationButton extends Button {

    static int numberOfFilledTextArea;

    public ValidateQuestionCreationButton()
    {
        this.setText(UtilStringStorage.validateCreationButton);
        this.setFont(Font.font(QuestionCreatorScene.POLICE_LABEL, FontWeight.BOLD, 25));
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
    }

    public static boolean setValidateButtonOnAction(List<QuestionCreatorTextArea> textAreaList, QuestionCreatorTextArea goodAnswerTextArea,  List<QuestionCreatorTextArea> answerTextAreaList)
    {
            QuestionCreatorScene.getIsCreatedLabel().setText("");
            ValidateQuestionCreationButton.checkForValidateQuestion(textAreaList);
            
            if(ValidateQuestionCreationButton.getNumberOfFilledTextArea() == 8 && ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                QuestionCreatorScene.setUpQuestionIsForgedLabel();
                return true;
            }
            else if(ValidateQuestionCreationButton.getNumberOfFilledTextArea() != 8 && ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                QuestionCreatorScene.setUpQuestionIsNotForgedAreaAreNotFiledLabel();
            }
            else if(ValidateQuestionCreationButton.getNumberOfFilledTextArea() == 8 && !ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                QuestionCreatorScene.setUpQuestionIsNotForgedValidAnswerIsNotGood();
            }
            else if(ValidateQuestionCreationButton.getNumberOfFilledTextArea() != 8 && !ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                QuestionCreatorScene.setUpQuestionIsNotForgedAreaAreNotFiledLabel();
            }
        return false;
    }

    public static void checkForValidateQuestion(List<QuestionCreatorTextArea> textAreaList)
    {
        numberOfFilledTextArea = 0;
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList)
        {
            if (questionCreatorTextArea.isFill() && !questionCreatorTextArea.getText().equals("")) {
                questionCreatorTextArea.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.GREEN));
                numberOfFilledTextArea++;
            }
            else {
                questionCreatorTextArea.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.RED));
            }
        }
    }

    public static boolean findAnswerEqualToGoodAnswer(QuestionCreatorTextArea goodAnswer, List<QuestionCreatorTextArea> answerList)
    {
        boolean findValidAnswer = false;
        int numberOfValidAnswer = 0;
        for (QuestionCreatorTextArea questionCreatorTextArea : answerList)
        {
            if (questionCreatorTextArea.getText().equals(goodAnswer.getText()))
            {
                numberOfValidAnswer++;
            }
        }
        if(numberOfValidAnswer == 1)
        {
            findValidAnswer = true;
            goodAnswer.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.GREEN));
        }
        else {
            goodAnswer.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.RED));
        }
        return findValidAnswer;
    }

    public static int getNumberOfFilledTextArea() {
        return numberOfFilledTextArea;
    }
}
