package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.*;

public class CreditScene extends Scene
{
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final BorderPane pane;
    private VBox creditVbox;
    public CreditScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.pane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;

        createReturnButton();
        createBackground();
        createCreditArea();

    }

    public void createReturnButton()
    {
        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        Button returnButton = new Button();
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnButton.setTooltip(returnTooltip);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        returnButton.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        returnButton.setPrefHeight(50);
        returnButton.setPrefWidth(50);
        pane.setTop(returnButton);
        returnButton.setOnAction(event -> backToMainMenu());

    }

    public void setUpLabels(Label label, String string, int labelSize, int translateX, int translateY)
    {
        label.setText(string);
        label.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, labelSize));
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
    }

    public void createCreditArea()
    {
        creditVbox = new VBox();

        Label generalThankLabel = new Label();
        setUpLabels(generalThankLabel, UtilStringStorage.generalThank, 19, 300, 10);

        Label kebabThank = new Label();
        setUpLabels(kebabThank, UtilStringStorage.kebabThank, 16, 250, 30);

        Label pandaThank = new Label();
        setUpLabels(pandaThank, UtilStringStorage.pandaThank, 16, 250, 50);

        Label satanThank = new Label();
        setUpLabels(satanThank, UtilStringStorage.satanThank, 16, 250, 70);

        Label givrThank = new Label();
        setUpLabels(givrThank, UtilStringStorage.givrThank, 16, 250, 90);

        Label yukiThank = new Label();
        setUpLabels(yukiThank, UtilStringStorage.yukiThank, 16, 250, 110);

        Label darkwestThank = new Label();
        setUpLabels(darkwestThank, UtilStringStorage.darkwestThank, 16, 250, 130);

        Label darkantThank = new Label();
        setUpLabels(darkantThank, UtilStringStorage.darkantThank, 16, 250, 150);

        Label loveLabel = new Label();
        setUpLabels(loveLabel, UtilStringStorage.loveLabel, 19, 300, 170);

        addLabelInVbox(generalThankLabel, kebabThank, pandaThank, satanThank, givrThank, yukiThank, darkwestThank, darkantThank, loveLabel);

        pane.setCenter(creditVbox);

    }

    public void addLabelInVbox(Label label1, Label label2, Label label3, Label label4, Label label5, Label label6, Label label7, Label label8, Label label9)
    {
        creditVbox.getChildren().add(label1);
        creditVbox.getChildren().add(label2);
        creditVbox.getChildren().add(label3);
        creditVbox.getChildren().add(label4);
        creditVbox.getChildren().add(label5);
        creditVbox.getChildren().add(label6);
        creditVbox.getChildren().add(label7);
        creditVbox.getChildren().add(label8);
        creditVbox.getChildren().add(label9);
    }

    public void createBackground()
    {
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        BackgroundImage backgroundImage = new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        pane.setBackground(new Background(backgroundImage));
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
