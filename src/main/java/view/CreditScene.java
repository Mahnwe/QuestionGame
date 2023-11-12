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
        label.setFont(Font.font("Impact", FontWeight.BOLD, labelSize));
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
    }

    public void setUpLinkLabels(Hyperlink hyperlink, int labelSize, int translateX, int translateY)
    {
        hyperlink.setFont(Font.font("Impact", FontWeight.BOLD, labelSize));
        hyperlink.setTranslateX(translateX);
        hyperlink.setTranslateY(translateY);
    }

    public void createCreditArea()
    {
        creditVbox = new VBox();

        Label generalThankLabel = new Label();
        setUpLabels(generalThankLabel, UtilStringStorage.generalThank,  20, 190, 40);

        Label kebabThank = new Label();
        setUpLabels(kebabThank, UtilStringStorage.kebabThank, 17, 140, 60);

        Label pandaThank = new Label();
        setUpLabels(pandaThank, UtilStringStorage.pandaThank, 17, 140, 80);

        Label satanThank = new Label();
        setUpLabels(satanThank, UtilStringStorage.satanThank, 17, 140, 100);

        Label givrThank = new Label();
        setUpLabels(givrThank, UtilStringStorage.givrThank, 17, 140, 120);

        Label yukiThank = new Label();
        setUpLabels(yukiThank, UtilStringStorage.yukiThank, 17, 140, 140);

        Label darkwestThank = new Label();
        setUpLabels(darkwestThank, UtilStringStorage.darkwestThank, 17, 140, 160);

        Label darkantThank = new Label();
        setUpLabels(darkantThank, UtilStringStorage.darkantThank, 17, 140, 180);

        Label bestLabel = new Label();
        setUpLabels(bestLabel, UtilStringStorage.loveLabel, 20, 190, 200);

        addLabelInVbox(generalThankLabel, kebabThank, pandaThank, satanThank, givrThank);
        addLabelInVboxPart2(yukiThank, darkwestThank, darkantThank, bestLabel);

        Label linkLabel = new Label();
        setUpLabels(linkLabel, UtilStringStorage.linkLabel, 20, 670, -80);

        Hyperlink hyperLinkIcon = App.hyperLinkIcon;
        setUpLinkLabels(hyperLinkIcon, 17, 610, -50);

        Hyperlink hyperlinkBackground = App.hyperLinkBackground;
        setUpLinkLabels(hyperlinkBackground, 17, 610, -30);

        creditVbox.getChildren().add(linkLabel);
        creditVbox.getChildren().add(hyperLinkIcon);
        creditVbox.getChildren().add(hyperlinkBackground);

        pane.setCenter(creditVbox);

    }

    public void addLabelInVbox(Label label1, Label label2, Label label3, Label label4, Label label5)
    {
        creditVbox.getChildren().add(label1);
        creditVbox.getChildren().add(label2);
        creditVbox.getChildren().add(label3);
        creditVbox.getChildren().add(label4);
        creditVbox.getChildren().add(label5);
    }

    public void addLabelInVboxPart2(Label label6, Label label7, Label label8, Label label9)
    {
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
