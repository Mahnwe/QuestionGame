package util;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LanguageButton extends Button {

    private final BorderWidths borderWidths = new BorderWidths(2.0);
    private final Border border = new Border(new BorderStroke(Color.GHOSTWHITE,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths));

    public LanguageButton (String imagePath, String tooltipLanguage)
    {
        IconCreator englishIcon = new IconCreator(imagePath);
        Image englishFlag = englishIcon.createImage().getImage();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        this.setMinWidth(75);
        this.setMinHeight(50);
        this.setTranslateX(40);
        this.setTranslateY(30);
        Tooltip buttonTooltip = new Tooltip(tooltipLanguage);
        this.setTooltip(buttonTooltip);
        this.setOnMouseEntered(event -> this.setBorder(border));
        this.setOnMouseExited(event -> this.setBorder(null));
    }
}
