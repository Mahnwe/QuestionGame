package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class ConfirmAlert extends Alert {


    public ConfirmAlert(AlertType alertType)
    {
        super(alertType);
        modifyConfirmAlert();
    }

    public void modifyConfirmAlert()
    {
        this.setTitle(UtilStringStorage.confirmAlertWindow);
        this.setHeaderText(UtilStringStorage.askToConfirm);

        IconCreator iconCreator = new IconCreator(PathUtil.QUESTION_MARK_TEST);
        ImageView backgroundImage = iconCreator.createImage();
        backgroundImage.setFitHeight(150);
        this.setGraphic(backgroundImage);

        Button confirmButton = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        confirmButton.setText(UtilStringStorage.yesButton);
        placeButton(confirmButton, -20, -140);

        Button cancelButton = (Button) this.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText(UtilStringStorage.noButton);
        placeButton(cancelButton, -20, -40);
    }

    public void placeButton(Button button, int translateY, int translateX)
    {
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }
}
