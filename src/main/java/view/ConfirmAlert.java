package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class ConfirmAlert extends Alert {


    public ConfirmAlert(AlertType alertType)
    {
        super(alertType);
    }

    public void modifyConfirmAlert(String headerText)
    {
        this.setTitle(UtilStringStorage.confirmAlertWindow);

        Label confirmReset = new Label(headerText);
        confirmReset.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 23));

        this.setHeaderText(headerText);

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(160);
        this.setGraphic(backgroundImage);

        Button confirmButton = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        CustomOption.setGlowEffectOnButton(confirmButton);
        confirmButton.setText(UtilStringStorage.yesButton);
        confirmButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
        placeButton(confirmButton, -20, -250);

        Button cancelButton = (Button) this.getDialogPane().lookupButton(ButtonType.CANCEL);
        CustomOption.setGlowEffectOnButton(cancelButton);
        cancelButton.setText(UtilStringStorage.noButton);
        cancelButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
        placeButton(cancelButton, -20, -100);

    }

    public void modifyConfirmAlertForSaveDelete(ConfirmAlert confirmAlert)
    {
        confirmAlert.setTitle(UtilStringStorage.confirmAlertWindow);

        Label confirmReset = new Label(UtilStringStorage.askToResetScore);
        confirmReset.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 23));

        confirmAlert.setHeaderText(confirmReset.getText());

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(150);
        confirmAlert.setGraphic(backgroundImage);

        Button confirmButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.OK);
        CustomOption.setGlowEffectOnButton(confirmButton);
        confirmButton.setText(UtilStringStorage.yesButton);
        confirmButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
        placeButton(confirmButton, -20, -250);

        Button cancelButton = (Button) confirmAlert.getDialogPane().lookupButton(ButtonType.CANCEL);
        CustomOption.setGlowEffectOnButton(cancelButton);
        cancelButton.setText(UtilStringStorage.noButton);
        cancelButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 19));
        placeButton(cancelButton, -20, -100);

    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }
}
