package util;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.creators.IconCreator;
import view.scene.MenuScene;

public class CustomOption {
    public static final Glow glow = new Glow(0.3);

    public static void customSlider(Slider slider, int width, int height, int translateY, int translateX)
    {
        slider.setMinWidth(width);
        slider.setMaxHeight(height);
        slider.setTranslateY(translateY);
        slider.setTranslateX(translateX);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(0.1);
    }

    public static void customMuteButton(Button button, String pathImage, int translateY, int translateX)
    {
        IconCreator muteIcon = new IconCreator(pathImage);
        Image muteImage = muteIcon.createImage().getImage();

        button.setPrefSize(50,50);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        button.setBackground(new Background(new BackgroundImage(muteImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        button.setTranslateY(translateY);
        button.setTranslateX(translateX);
        setGlowEffectOnButton(button);
    }

    public static void customExitToMenuButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 28));
        button.setTranslateY(200);
        button.setTranslateX(305);
        setGlowEffectOnButton(button);
    }

    public static void setGlowEffectOnButton(Button button)
    {
        button.setOnMouseEntered(event -> button.setEffect(glow));
        button.setOnMouseExited(event -> button.setEffect(null));
    }

    public static void setUpTrashButton(Button button, String tooltipString)
    {
        IconCreator trashIcon = new IconCreator(PathUtil.TRASH_ICON);
        Image trashImage = trashIcon.createImage().getImage();

        button.setPrefSize(90,90);
        Tooltip resetTooltip = new Tooltip(tooltipString);
        resetTooltip.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        button.setTooltip(resetTooltip);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        button.setBackground(new Background(new BackgroundImage(trashImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        setGlowEffectOnButton(button);
    }

    public static Border createCustomBorder(double cornerRadiiValue, double borderWidthsValue, Color color)
    {
        CornerRadii cornerRadii = new CornerRadii(cornerRadiiValue);
        BorderWidths borderWidths = new BorderWidths(borderWidthsValue);
        return new Border(new BorderStroke(color,
                BorderStrokeStyle.SOLID, cornerRadii, borderWidths));
    }
}
