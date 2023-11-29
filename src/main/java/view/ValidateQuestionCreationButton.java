package view;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.UtilStringStorage;

import java.util.List;

public class ValidateQuestionCreationButton extends Button {

    int numberOfFilledTextArea;

    public ValidateQuestionCreationButton()
    {
        this.setText(UtilStringStorage.validateCreationButton);
        this.setFont(Font.font(QuestionCreatorScene.POLICE_LABEL, FontWeight.BOLD, 25));
        this.setDisable(true);
    }

    public void checkForValidateQuestion(List<QuestionCreatorTextArea> textAreaList)
    {
        numberOfFilledTextArea = 0;
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList) {
            if (questionCreatorTextArea.isFill()) {
                numberOfFilledTextArea++;
            }
        }
    }

    public int getNumberOfFilledTextArea() {
        return numberOfFilledTextArea;
    }
}
