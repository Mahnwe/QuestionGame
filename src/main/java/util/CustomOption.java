package util;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class CustomOption {

    public static void customSlider(Slider slider, int width, int height, int translateY, int translateX)
    {
        slider.setMaxWidth(width);
        slider.setMaxHeight(height);
        slider.setTranslateY(translateY);
        slider.setTranslateX(translateX);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1f);
        slider.setBlockIncrement(1f);
    }

    public static void customMuteButton(Button button, String pathImage, int translateY, int translateX)
    {
        IconCreator muteIcon = new IconCreator(pathImage);
        Image muteImage = muteIcon.createImage().getImage();

        button.setPrefSize(30,30);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        button.setBackground(new Background(new BackgroundImage(muteImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
    }
}
