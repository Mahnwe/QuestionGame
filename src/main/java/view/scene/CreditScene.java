package view.scene;

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
import model.handlers.AchievementManager;
import util.creators.BackgroundCreator;
import util.stringutiltranslate.UtilStringStorage;
import view.App;
import view.customobject.ReturnButton;

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
        createVboxArea();
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
        label.setFont(Font.font("Futura", FontWeight.BOLD, labelSize));
        label.setTranslateX(translateX);
        label.setTranslateY(translateY);
    }

    public void setUpLinkLabels(Hyperlink hyperlink, int labelSize, int translateX, int translateY)
    {
        hyperlink.setFont(Font.font("Futura", FontWeight.BOLD, labelSize));
        hyperlink.setTranslateX(translateX);
        hyperlink.setTranslateY(translateY);
    }

    public void createVboxArea()
    {
        creditVbox = new VBox();

        createCreditLabelArea();
        createCreditLinkArea();

        pane.setCenter(creditVbox);
        creditVbox.setTranslateX(300);
        creditVbox.setTranslateY(100);
    }

    public void createCreditLabelArea()
    {
        Label generalThankLabel = new Label();
        setUpLabels(generalThankLabel, UtilStringStorage.generalThank,  35, 160, 30);
        generalThankLabel.setFont(Font.font("Impact", FontWeight.BOLD, 35));

        Label kebabThank = new Label();
        setUpLabels(kebabThank, UtilStringStorage.kebabThank, 26, 70, 70);

        Label pandaThank = new Label();
        setUpLabels(pandaThank, UtilStringStorage.pandaThank, 26, 70, 120);

        Label satanThank = new Label();
        setUpLabels(satanThank, UtilStringStorage.satanThank, 26, 70, 170);

        Label givrThank = new Label();
        setUpLabels(givrThank, UtilStringStorage.givrThank, 26, 70, 220);

        Label yukiThank = new Label();
        setUpLabels(yukiThank, UtilStringStorage.yukiThank, 26, 70, 270);

        Label darkwestThank = new Label();
        setUpLabels(darkwestThank, UtilStringStorage.darkwestThank, 26, 70, 320);

        Label darkantThank = new Label();
        setUpLabels(darkantThank, UtilStringStorage.darkantThank, 26, 70, 370);

        Label bestLabel = new Label();
        setUpLabels(bestLabel, UtilStringStorage.loveLabel, 30, 140, 420);

        addLabelInVbox(generalThankLabel, kebabThank, pandaThank, satanThank, givrThank);
        addLabelInVboxPart2(yukiThank, darkwestThank, darkantThank, bestLabel);
    }

    public void createCreditLinkArea()
    {
        Label linkLabel = new Label();
        setUpLabels(linkLabel, UtilStringStorage.linkLabel, 35, 940, -120);
        linkLabel.setFont(Font.font("Impact", FontWeight.BOLD, 35));

        Hyperlink hyperLinkIcon = App.hyperLinkIcon;
        setUpLinkLabels(hyperLinkIcon, 26, 850, -90);

        Hyperlink hyperLinkIcon2 = App.hyperLinkIcon2;
        setUpLinkLabels(hyperLinkIcon2, 26, 850, -70);

        Hyperlink hyperlinkBackground = App.hyperLinkBackground;
        setUpLinkLabels(hyperlinkBackground, 26, 850, -50);

        creditVbox.getChildren().add(linkLabel);
        creditVbox.getChildren().add(hyperLinkIcon);
        creditVbox.getChildren().add(hyperLinkIcon2);
        creditVbox.getChildren().add(hyperlinkBackground);
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
