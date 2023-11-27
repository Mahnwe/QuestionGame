package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;

import java.util.List;

public class AnswerButton extends Button
{
    private boolean isClicked;
    public AnswerButton(boolean buttonIsClicked, String text)
    {
        isClicked = buttonIsClicked;
        String upperText = text.toUpperCase();
        this.setText(upperText);
        this.setFont(Font.font("Futura", FontWeight.BOLD, 18));
    }

    public void setAnswerButtonOnAction(AnswerButton answerButton, List<AnswerButton> buttonList, Button validateButton)
    {
        answerButton.setOnAction(event -> {
        answerButton.checkOthersButtonClicked(buttonList);
        answerButton.setClicked(true);
        answerButton.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        answerButton.setTextFill(Color.GHOSTWHITE);
        validateButton.setDisable(false);
        });
        CustomOption.setGlowEffectOnButton(answerButton);
    }

    public void checkOthersButtonClicked(List<AnswerButton> buttonList)
    {
        for (AnswerButton answerButton : buttonList) {
            answerButton.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            answerButton.setTextFill(Color.BLACK);
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
