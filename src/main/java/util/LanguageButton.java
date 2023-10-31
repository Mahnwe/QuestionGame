package util;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class LanguageButton extends Button {

    public LanguageButton (String imagePath)
    {
        IconCreator englishIcon = new IconCreator(imagePath);
        Image englishFlag = englishIcon.createImage().getImage();
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(englishFlag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        this.setMinWidth(60);
        this.setMinHeight(35);
        this.setTranslateX(40);
        this.setTranslateY(10);
    }
}
