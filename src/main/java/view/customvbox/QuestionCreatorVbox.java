package view.customvbox;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class QuestionCreatorVbox extends VBox {

    public QuestionCreatorVbox(Label label, TextArea textArea)
    {
        this.getChildren().add(label);
        this.getChildren().add(textArea);
        textArea.setMaxHeight(30);
        textArea.setTranslateY(5);
    }
}
