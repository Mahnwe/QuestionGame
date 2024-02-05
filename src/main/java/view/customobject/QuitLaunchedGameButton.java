package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.CustomOption;
import util.IconCreator;
import util.PathUtil;

public class QuitLaunchedGameButton extends Button {

    public QuitLaunchedGameButton(String buttonText)
    {
        this.setText(buttonText);
        this.setFont(Font.font("Futura", FontWeight.BOLD, 24));
        this.setBorder(CustomOption.createCustomBorder(2.0, 2.0, Color.BLACK));

        IconCreator personalizeIcon = new IconCreator(PathUtil.MENU_BACKGROUND);
        ImageView personalizeImage = personalizeIcon.createImage();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(personalizeImage.getImage(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        CustomOption.setGlowEffectOnButton(this);
        this.setOnMouseEntered(event -> this.setBorder(CustomOption.createCustomBorder(2.0, 2.0, Color.GHOSTWHITE)));
        this.setOnMouseExited(event -> this.setBorder(CustomOption.createCustomBorder(2.0, 2.0, Color.BLACK)));
    }
}
