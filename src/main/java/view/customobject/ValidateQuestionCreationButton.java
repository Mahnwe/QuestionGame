package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;
import util.UtilStringStorage;
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

    public void checkForValidateQuestion(List<QuestionCreatorTextArea> textAreaList)
    {
        numberOfFilledTextArea = 0;
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList) {
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
