package util;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DeveloperVbox extends VBox {
    private static final String DEV_LABEL = "Impact";
    public DeveloperVbox()
    {
        ImageView devLurkImage = IconCreator.createDevImage();

        Label nameLabel = new Label("ManawéGames");
        nameLabel.setFont(Font.font(DEV_LABEL, FontWeight.EXTRA_BOLD, 17));
        nameLabel.setTextFill(Color.GHOSTWHITE);
        nameLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        BorderWidths borderWidths = new BorderWidths(1.0);
        CornerRadii cornerRadii = new CornerRadii(3.0);
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cornerRadii, borderWidths));
        nameLabel.setBorder(border);

        this.getChildren().add(devLurkImage);
        this.getChildren().add(nameLabel);
    }
}
