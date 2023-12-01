package view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuestionCreatorTextArea extends TextArea
{
    private final CornerRadii cornerRadii = new CornerRadii(1.5);
    private final BorderWidths borderWidths = new BorderWidths(2.0);
    private final Border blackBorder = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, cornerRadii, borderWidths));
    private final Border redBorder = new Border(new BorderStroke(Color.RED,
            BorderStrokeStyle.SOLID, cornerRadii, borderWidths));
    private boolean isFill = false;
        public QuestionCreatorTextArea(int maxCharactersInArea)
        {
            this.setMaxWidth(400);
            this.setFont(Font.font(PlayerInfoScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 16));
            this.setBorder(blackBorder);
            this.setOnKeyTyped(event -> {
                if(!this.getText().isBlank())
                {
                    isFill = true;
                }
                if (this.getText().length() > maxCharactersInArea)
                {
                    this.deletePreviousChar();
                }
            });
        }

    public boolean isFill() {
        return isFill;
    }

    public void setFill(boolean fill) {
        isFill = fill;
    }

    public Border getBlackBorder() {
        return blackBorder;
    }

    public Border getRedBorder() {
        return redBorder;
    }
}

