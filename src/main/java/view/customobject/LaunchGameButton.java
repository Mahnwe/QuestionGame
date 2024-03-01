package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.handlers.GameHandler;
import util.CustomOption;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.MenuScene;

public class LaunchGameButton extends Button {
    public LaunchGameButton(CustomComboBox comboBox, GameHandler gameHandler, MenuScene menuScene)
    {
        this.setText(UtilStringStorage.launchGameButton);
        this.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 30));
        this.setTranslateX(320);
        this.setTranslateY(235);
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        CustomOption.setGlowEffectOnButton(this);
        setLaunchGameButtonOnAction(comboBox, gameHandler, menuScene);
    }

    public void setLaunchGameButtonOnAction(CustomComboBox comboBox, GameHandler gameHandler, MenuScene menuScene)
    {
        this.setOnAction(event ->
        {
            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(0))) {
                gameHandler.setupQuestionList(10);
                menuScene.instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(1))) {
                gameHandler.setupQuestionList(15);
                menuScene.instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(2))) {
                gameHandler.setupQuestionList(20);
                menuScene.instantiateMainScene();
            }

            if(comboBox.getSelectionModel().getSelectedItem().equals(comboBox.getItems().get(3))) {
                gameHandler.setUpSurvivalMode();
                menuScene.instantiateMainScene();
            }
        });
    }
}
