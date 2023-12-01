package view;

import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;

public class QuestionCreatorTextArea extends TextArea
{
    private boolean isFill = false;
        public QuestionCreatorTextArea(int maxCharactersInArea)
        {
            this.setMaxWidth(400);
            this.setFont(Font.font(PlayerInfoScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 16));
            this.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.BLACK));
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
}

