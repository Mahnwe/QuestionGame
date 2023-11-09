package util;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.MenuScene;

import java.util.List;

public class AnswerButton extends Button
{

    private final BorderWidths borderWidths = new BorderWidths(2.0);
    private final CornerRadii cornerRadii = new CornerRadii(5.0);
    private final Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, cornerRadii, borderWidths));
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
        answerButton.setBorder(border);
        validateButton.setDisable(false);
        });
    }

    public void checkOthersButtonClicked(List<AnswerButton> buttonList)
    {
        for (AnswerButton answerButton : buttonList) {
            answerButton.setBorder(null);
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
