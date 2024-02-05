package util;

import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.scene.MenuScene;

public class CustomOption {
    public static final Glow glow = new Glow(0.3);
    private static Label tenModeButton;
    private static Label fifteenModeButton;
    private static Label twentyModeButton;
    private static Label survivalModeButton;


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

    public static void customLaunchButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 30));
        button.setTranslateX(320);
        button.setTranslateY(235);
        button.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        setGlowEffectOnButton(button);
    }

    public static void customComboBox(ComboBox<String> comboBox)
    {
        createLabel();

        comboBox.setStyle("-fx-font: 30px \"Futura\"");
        comboBox.setMinHeight(70);
        comboBox.setMinWidth(170);
        comboBox.setTranslateX(282);
        comboBox.setTranslateY(150);
        comboBox.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        comboBox.setOnMouseEntered(event -> comboBox.setEffect(glow));
        comboBox.setOnMouseExited(event -> comboBox.setEffect(null));

        comboBox.getItems().add(tenModeButton.getText());
        comboBox.getItems().add(fifteenModeButton.getText());
        comboBox.getItems().add(twentyModeButton.getText());
        comboBox.getItems().add(survivalModeButton.getText());
        comboBox.getSelectionModel().selectFirst();
    }

    public static void createLabel()
    {
        tenModeButton = new Label(UtilStringStorage.mode10Button);
        tenModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        tenModeButton.setTextFill(Color.BLACK);

        fifteenModeButton = new Label(UtilStringStorage.mode15Button);
        fifteenModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        fifteenModeButton.setTextFill(Color.BLACK);

        twentyModeButton = new Label(UtilStringStorage.mode20Button);
        twentyModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        twentyModeButton.setTextFill(Color.BLACK);

        survivalModeButton = new Label(UtilStringStorage.modeSurvivalButton);
        survivalModeButton.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        survivalModeButton.setTextFill(Color.BLACK);
    }

    public static void customExitToMenuButton(Button button)
    {
        button.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 25));
        button.setTranslateY(160);
        button.setTranslateX(285);
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
        resetTooltip.setFont(Font.font("Futura", FontWeight.BOLD, 18));
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
