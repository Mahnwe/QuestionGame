package view;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class NotificationAlert extends Alert
{
    private final Alert successAlert;
    public NotificationAlert(AlertType alertType)
    {
        super(alertType);
        successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setHeight(50);
        successAlert.setWidth(50);
        designAlertNotif();
    }

    public void designAlertNotif()
    {
        IconCreator notifIcon = new IconCreator(PathUtil.NOTIF_ICON);
        ImageView notifImage = notifIcon.createImage();
        notifImage.setFitWidth(40);
        notifImage.setFitHeight(40);
        successAlert.setTitle(UtilStringStorage.notificationTitle);
        successAlert.setHeaderText(UtilStringStorage.notificationText);
        successAlert.setGraphic(notifImage);
    }

    public void showAlert()
    {
        successAlert.show();
    }

}
