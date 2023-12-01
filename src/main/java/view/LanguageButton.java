package view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import util.CustomOption;
import util.IconCreator;

public class LanguageButton extends Button {

    public LanguageButton (String imagePath, String tooltipLanguage)
    {
        IconCreator englishIcon = new IconCreator(imagePath);
        Image englishFlag = englishIcon.createImage().getImage();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));

        this.setMinWidth(130);
        this.setMinHeight(80);
        this.setTranslateX(40);
        this.setTranslateY(30);

        Tooltip buttonTooltip = new Tooltip(tooltipLanguage);
        this.setTooltip(buttonTooltip);

        this.setOnMouseEntered(event -> {
            this.setEffect(CustomOption.glow);
            this.setBorder(CustomOption.createCustomBorder(1.0, 2.0, Color.GHOSTWHITE));
        });

        this.setOnMouseExited(event -> {
            this.setEffect(null);
            this.setBorder(null);
        });
    }
}
