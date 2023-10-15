package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

public class CreditScene extends Scene
{
    private final Stage stage;
    private final AchievementManager achievementManager;
    private final BorderPane pane;
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

    public void createCreditArea()
    {
        VBox creditVbox = new VBox();
        Label creditLabel = new Label();
        String creditStringBuilder = UtilStringStorage.generalThank +"\n"+
                UtilStringStorage.kebabThank +"\n"+
                UtilStringStorage.pandaThank +"\n"+
                UtilStringStorage.satanThank +"\n"+
                UtilStringStorage.givrThank +"\n"+
                UtilStringStorage.yukiThank +"\n"+
                UtilStringStorage.darkwestThank +"\n"+
                UtilStringStorage.darkantThank +"\n"+
                UtilStringStorage.loveLabel;
        creditLabel.setText(creditStringBuilder);
        creditVbox.getChildren().add(creditLabel);
        pane.setCenter(creditVbox);

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
