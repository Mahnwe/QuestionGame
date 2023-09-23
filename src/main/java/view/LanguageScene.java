package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LanguageScene extends Scene {

    private final Button engButton;
    private final Button frButton;
    public LanguageScene(BorderPane pane)
    {
        super(pane);
        VBox vBox = new VBox();
        vBox.setPrefHeight(200);
        vBox.setPrefWidth(200);



        engButton = new Button("English");
        engButton.setMinWidth(60);

        frButton = new Button("Francais");
        frButton.setMinWidth(60);


        vBox.getChildren().add(engButton);
        vBox.getChildren().add(frButton);
        pane.getChildren().add(vBox);
    }

    public Button getEngButton() {
        return engButton;
    }

    public Button getFrButton() {
        return frButton;
    }
}
