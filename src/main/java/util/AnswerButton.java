package util;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.MenuScene;

import java.util.List;

public class AnswerButton extends Button {
    private boolean isClicked;
    public AnswerButton(boolean buttonIsClicked, String text)
    {
        isClicked = buttonIsClicked;
        this.setText(text);
        this.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 14));
    }

    public void setAnswerButtonOnAction(AnswerButton answerButton, List<AnswerButton> buttonList, Button validateButton)
    {
        answerButton.setOnAction(event -> {
        answerButton.checkOthersButtonClicked(buttonList);
        answerButton.setClicked(true);
        validateButton.setDisable(false);
        });
    }

    public void checkOthersButtonClicked(List<AnswerButton> buttonList)
    {
        for (AnswerButton answerButton : buttonList) {
            if (answerButton.isClicked) {
                answerButton.isClicked = false;
            }
        }
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
