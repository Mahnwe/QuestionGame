package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.handlers.PersonalizeQuestionsHandler;
import util.CustomOption;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.QuestionCreatorScene;

import java.util.List;

public class ValidateQuestionCreationButton extends Button {

    int numberOfFilledTextArea;

    public ValidateQuestionCreationButton()
    {
        this.setText(UtilStringStorage.validateCreationButton);
        this.setFont(Font.font(QuestionCreatorScene.POLICE_LABEL, FontWeight.BOLD, 25));
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
    }

    public void setValidateButtonOnAction(ValidateQuestionCreationButton validateQuestionCreationButton, List<QuestionCreatorTextArea> textAreaList, QuestionCreatorTextArea goodAnswerTextArea,  List<QuestionCreatorTextArea> answerTextAreaList)
    {
        validateQuestionCreationButton.setOnAction(event -> {
            QuestionCreatorScene.getIsCreatedLabel().setText("");
            validateQuestionCreationButton.checkForValidateQuestion(textAreaList);
            if(validateQuestionCreationButton.getNumberOfFilledTextArea() == 8 && ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                PersonalizeQuestionsHandler.addNewQuestionToPropertiesFile(textAreaList);
                QuestionCreatorScene.setUpQuestionIsForgedLabel();
            }
            else if(validateQuestionCreationButton.getNumberOfFilledTextArea() != 8 && ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList)) {
                QuestionCreatorScene.setUpQuestionIsNotForgedAreaAreNotFiledLabel();
            }
            else if(validateQuestionCreationButton.getNumberOfFilledTextArea() == 8 && !ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                QuestionCreatorScene.setUpQuestionIsNotForgedValidAnswerIsNotGood();
            }
            else if(validateQuestionCreationButton.getNumberOfFilledTextArea() != 8 && !ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList)) {
                QuestionCreatorScene.setUpQuestionIsNotForgedAreaAreNotFiledLabel();
            }
        });
    }

    public void checkForValidateQuestion(List<QuestionCreatorTextArea> textAreaList)
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
        for(int i = 0; i < answerList.size(); i++)
        {
            if(answerList.get(i).getText().equals(goodAnswer.getText()))
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

    public int getNumberOfFilledTextArea() {
        return numberOfFilledTextArea;
    }
}
