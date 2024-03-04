package view.customobject;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.MenuScene;

public class CustomComboBox extends ComboBox<String> {
    private static Label tenModeButton;
    private static Label fifteenModeButton;
    private static Label twentyModeButton;
    private static Label survivalModeButton;

    public CustomComboBox()
    {
        customComboBox();
    }
    public void createLabel()
    {
        tenModeButton = new Label(UtilStringStorage.mode10Button);
        tenModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        tenModeButton.setTextFill(Color.BLACK);

        fifteenModeButton = new Label(UtilStringStorage.mode15Button);
        fifteenModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        fifteenModeButton.setTextFill(Color.BLACK);

        twentyModeButton = new Label(UtilStringStorage.mode20Button);
        twentyModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        twentyModeButton.setTextFill(Color.BLACK);

        survivalModeButton = new Label(UtilStringStorage.modeSurvivalButton);
        survivalModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        survivalModeButton.setTextFill(Color.BLACK);
    }

    public void customComboBox()
    {
        createLabel();

        this.setStyle("-fx-font: 30px \"Futura\"");
        this.setMinHeight(70);
        this.setMinWidth(170);
        this.setTranslateX(282);
        this.setTranslateY(150);
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        this.setOnMouseEntered(event -> this.setEffect(CustomOption.glow));
        this.setOnMouseExited(event -> this.setEffect(null));

        this.getItems().add(tenModeButton.getText());
        this.getItems().add(fifteenModeButton.getText());
        this.getItems().add(twentyModeButton.getText());
        this.getItems().add(survivalModeButton.getText());
        this.getSelectionModel().selectFirst();
    }
}
