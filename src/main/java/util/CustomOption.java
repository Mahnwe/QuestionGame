package util;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.MenuScene;

public class CustomOption {
    public static final Glow glow = new Glow(0.3);

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
        setGlowEffectOnButton(button);
    }

    public static void customLaunchButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 20));
        button.setTranslateX(295);
        button.setTranslateY(190);
        setGlowEffectOnButton(button);
    }

    public static void customComboBox(ComboBox<String> comboBox)
    {
        comboBox.setStyle("-fx-font: 20px \"Verdana\"");
        comboBox.setMinHeight(30);
        comboBox.setMinWidth(90);
        comboBox.setTranslateX(255);
        comboBox.setTranslateY(165);
        comboBox.setOnMouseEntered(event -> comboBox.setEffect(glow));
        comboBox.setOnMouseExited(event -> comboBox.setEffect(null));
    }

    public static void customResetSaveButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 15));
        Tooltip resetTooltip = new Tooltip(UtilStringStorage.resetTooltip);
        button.setTooltip(resetTooltip);
        setGlowEffectOnButton(button);

    }

    public static void customExitToMenuButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 16));
        button.setTranslateY(160);
        button.setTranslateX(260);
        setGlowEffectOnButton(button);
    }

    public static void setGlowEffectOnButton(Button button)
    {
        button.setOnMouseEntered(event -> button.setEffect(glow));
        button.setOnMouseExited(event -> button.setEffect(null));
    }
}
