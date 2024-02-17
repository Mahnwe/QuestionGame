package view.customvbox;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;
import util.creators.IconCreator;

public class DeveloperVbox extends VBox {
    private static final String DEV_LABEL = "Impact";

    public DeveloperVbox()
    {
        ImageView devLurkImage = IconCreator.createDevImage();

        Label nameLabel = new Label("Manawé Games");

        nameLabel.setFont(Font.font(DEV_LABEL, FontWeight.EXTRA_BOLD, 20));
        nameLabel.setTextFill(Color.GHOSTWHITE);
        nameLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        nameLabel.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));

        this.setMaxWidth(137);
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        Background background = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY));
        this.setBackground(background);

        this.getChildren().add(devLurkImage);
        this.getChildren().add(nameLabel);
    }
}
