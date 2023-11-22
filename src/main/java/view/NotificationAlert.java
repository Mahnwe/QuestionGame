package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class NotificationAlert extends Alert
{
    private final Alert successAlert;
    public static final String ALERT_POLICE = "Futura";
    public NotificationAlert(AlertType alertType)
    {
        super(alertType);
        successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setHeight(70);
        successAlert.setWidth(70);
        designAlertNotif();
    }

    public void designAlertNotif()
    {
        IconCreator notifIcon = new IconCreator(PathUtil.NOTIF_ICON);
        ImageView notifImage = notifIcon.createImage();
        notifImage.setFitWidth(50);
        notifImage.setFitHeight(50);

        Label notificationTitle = new Label(UtilStringStorage.notificationTitle);
        notificationTitle.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 23));

        Label notificationHeaderText = new Label(UtilStringStorage.notificationText);
        notificationHeaderText.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 23));

        successAlert.setTitle(notificationTitle.getText());
        successAlert.setHeaderText(notificationHeaderText.getText());
        successAlert.setGraphic(notifImage);

        Button alertOkButton = (Button) successAlert.getDialogPane().lookupButton(ButtonType.OK);
        alertOkButton.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 15));
        alertOkButton.setTranslateX(-140);
    }

    public void showAlert()
    {
        successAlert.show();
    }

}
