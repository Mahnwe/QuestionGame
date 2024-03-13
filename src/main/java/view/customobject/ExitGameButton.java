package view.customobject;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.TimePlayedTimer;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.MenuScene;

import java.util.Optional;

public class ExitGameButton extends Button
{
    ConfirmAlert confirmAlert;
    public ExitGameButton(String buttonText, String tooltipText, int translateX)
    {
        createConfirmAlert();

        this.setText(buttonText);
        Tooltip tooltip = new Tooltip(tooltipText);
        this.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 22));
        this.setTooltip(tooltip);
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        this.setTranslateX(translateX);

        CustomOption.setGlowEffectOnButton(this);
        setExitButtonOnAction(confirmAlert);
    }

    public void createConfirmAlert()
    {
        confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);
        confirmAlert.modifyConfirmAlert(UtilStringStorage.confirmQuitGameText);
    }

    public void setExitButtonOnAction(ConfirmAlert confirmAlert)
    {
        this.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                TimePlayedTimer.calculateTimer();
                Platform.exit();
            }
        });
    }
}
