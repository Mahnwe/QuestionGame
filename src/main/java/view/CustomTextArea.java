package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomTextArea extends TextArea {

    public CustomTextArea(Button button)
    {
        this.setFont(Font.font(PlayerInfoScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 19));
        this.setOnKeyTyped(event -> {
            int maxCharacters = 12;
            if(!this.getText().isEmpty())
            {
                button.setDisable(false);
            }
            if (this.getText().length() > maxCharacters)
            {
                this.deletePreviousChar();
            }

        });

        this.setMaxHeight(50);
        this.setMaxWidth(250);
        this.setTranslateY(75);
        this.setTranslateX(230);
    }
}
