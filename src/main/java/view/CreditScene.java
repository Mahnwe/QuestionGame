package view;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.BackgroundCreator;
import util.ReturnButton;
import util.UtilStringStorage;

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
        ReturnButton returnButton = new ReturnButton();
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

    public void setUpLinkLabels(Hyperlink hyperlink, int labelSize, int translateX, int translateY)
    {
        hyperlink.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, labelSize));
        hyperlink.setTranslateX(translateX);
        hyperlink.setTranslateY(translateY);
    }

    public void createCreditArea()
    {
        creditVbox = new VBox();

        Label generalThankLabel = new Label();
        setUpLabels(generalThankLabel, UtilStringStorage.generalThank, 19, 150, 10);

        Label kebabThank = new Label();
        setUpLabels(kebabThank, UtilStringStorage.kebabThank, 16, 100, 30);

        Label pandaThank = new Label();
        setUpLabels(pandaThank, UtilStringStorage.pandaThank, 16, 100, 50);

        Label satanThank = new Label();
        setUpLabels(satanThank, UtilStringStorage.satanThank, 16, 100, 70);

        Label givrThank = new Label();
        setUpLabels(givrThank, UtilStringStorage.givrThank, 16, 100, 90);

        Label yukiThank = new Label();
        setUpLabels(yukiThank, UtilStringStorage.yukiThank, 16, 100, 110);

        Label darkwestThank = new Label();
        setUpLabels(darkwestThank, UtilStringStorage.darkwestThank, 16, 100, 130);

        Label darkantThank = new Label();
        setUpLabels(darkantThank, UtilStringStorage.darkantThank, 16, 100, 150);

        Label loveLabel = new Label();
        setUpLabels(loveLabel, UtilStringStorage.loveLabel, 19, 150, 170);

        addLabelInVbox(generalThankLabel, kebabThank, pandaThank, satanThank, givrThank, yukiThank, darkwestThank, darkantThank, loveLabel);

        Label linkLabel = new Label();
        setUpLabels(linkLabel, UtilStringStorage.linkLabel, 19, 630, -100);

        Hyperlink hyperLinkIcon = App.hyperLinkIcon;
        setUpLinkLabels(hyperLinkIcon, 16, 570, -70);

        Hyperlink hyperlinkBackground = App.hyperLinkBackground;
        setUpLinkLabels(hyperlinkBackground, 16, 570, -50);

        creditVbox.getChildren().add(linkLabel);
        creditVbox.getChildren().add(hyperLinkIcon);
        creditVbox.getChildren().add(hyperlinkBackground);

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
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        pane.setBackground(new Background(backgroundImage));
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
