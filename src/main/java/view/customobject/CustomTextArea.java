package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.scene.PlayerInfoScene;

public class CustomTextArea extends TextArea {

    public CustomTextArea(Button button, int maxCharactersInArea)
    {
        this.setFont(Font.font(PlayerInfoScene.POLICE_LABEL, FontWeight.EXTRA_LIGHT, 19));
        this.setOnKeyTyped(event -> {
            if(!this.getText().isEmpty())
            {
                button.setDisable(false);
            }
            if (this.getText().length() > maxCharactersInArea)
            {
                this.deletePreviousChar();
            }

        });
    }
}
