package view.customobject;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class NotificationAlert extends Alert
{
    public static final String ALERT_POLICE = "Futura";
    public NotificationAlert(AlertType alertType)
    {
        super(alertType);
        this.setHeight(110);
        this.setWidth(120);
        designAlertNotif();
    }

    public void designAlertNotif()
    {
        IconCreator notifIcon = new IconCreator(PathUtil.NOTIF_ICON);
        ImageView notifImage = notifIcon.createImage();
        notifImage.setFitWidth(60);
        notifImage.setFitHeight(60);

        Label notificationTitle = new Label(UtilStringStorage.notificationTitle);
        notificationTitle.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 25));

        Label notificationHeaderText = new Label(UtilStringStorage.notificationText);
        notificationHeaderText.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 25));

        this.setTitle(notificationTitle.getText());
        this.setHeaderText(notificationHeaderText.getText());
        this.setGraphic(notifImage);

        Button alertOkButton = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        alertOkButton.setFont(Font.font(ALERT_POLICE, FontWeight.BOLD, 20));
        alertOkButton.setTranslateX(-140);
    }

    public static void hideAlertAfter5Sec(NotificationAlert notificationAlert)
    {
        notificationAlert.showAlert();
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(event -> notificationAlert.close());
        visiblePause.play();
    }

    public void showAlert()
    {
        this.show();
    }

}
