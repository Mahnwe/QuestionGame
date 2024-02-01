package view.scene;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.AchievementManager;
import model.PersonalizeQuestionsHandler;
import util.BackgroundCreator;
import util.CustomOption;
import util.FileUtil;
import util.UtilStringStorage;
import view.customobject.ConfirmAlert;
import view.customobject.ReturnButton;

import java.util.Optional;

public class PersonalizeQuestionListScene extends Scene {

    private final Stage stage;
    private final AchievementManager achievementManager;
    private final ConfirmAlert confirmAlert;
    private final BorderPane mainBorderPane;
    private VBox deletedAreaVbox;
    private GridPane gridpane;

    public static final String POLICE_LABEL = "Futura";
    private VBox questionListVbox;


    public PersonalizeQuestionListScene(ScrollPane scrollPane, Stage stage, AchievementManager achievementManager)
    {
        super(scrollPane);
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);

        this.mainBorderPane = new BorderPane();
        mainBorderPane.setMinHeight(1080);

        scrollPane.setPrefHeight(750);
        scrollPane.setPrefWidth(1200);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(mainBorderPane);

        createReturnButton();
        createBackground();
        createDeleteArea();
        createGridPaneList();
        createPersonalizeQuestionList();
        mainBorderPane.setCenter(questionListVbox);
    }
    public void createDeleteAllVbox()
    {
        VBox deleteAllVbox = new VBox();
        Label deleteAllLabel = new Label(UtilStringStorage.deleteAllLabel);
        deleteAllLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));

        Button deleteAllPersonalizeQuestionsButton = new Button();
        CustomOption.setUpTrashButton(deleteAllPersonalizeQuestionsButton, UtilStringStorage.deleteAllTooltip);
        deleteAllPersonalizeQuestionsButton.setTranslateX(10);

        Label questionsAreDeletedLabel = new Label(UtilStringStorage.questionAreDeleted);
        questionsAreDeletedLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));
        questionsAreDeletedLabel.setVisible(false);

       setOnActionDeleteAllQuestionsButton(deleteAllPersonalizeQuestionsButton, questionsAreDeletedLabel);

        deleteAllVbox.getChildren().add(deleteAllLabel);
        deleteAllVbox.getChildren().add(deleteAllPersonalizeQuestionsButton);
        deleteAllVbox.getChildren().add(questionsAreDeletedLabel);
        deletedAreaVbox.getChildren().add(deleteAllVbox);
    }

    public void setOnActionDeleteAllQuestionsButton(Button button, Label label)
    {
        button.setOnAction(event -> {
            label.setText(UtilStringStorage.questionAreDeleted);
            confirmAlert.modifyConfirmAlert(UtilStringStorage.confirmAlertDeleteAllQuestions);
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                if(PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber() > 0) {
                    FileUtil.resetPersonalizeQuestionFile();
                    backToMainMenu();
                    launchTransitionLabel(label);
                } else {
                    label.setText(UtilStringStorage.nothingToDelete);
                    launchTransitionLabel(label);
                }
                gridpane.getChildren().clear();
            }
        });
    }

    public void launchTransitionLabel(Label label)
    {
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(transitionEvent2 -> label.setVisible(false));
        visiblePause.play();
    }

    public void createGridPaneList()
    {
        gridpane = new GridPane();
        gridpane.setMinHeight(1080);
        GridPane.setVgrow(gridpane, Priority.ALWAYS);
        gridpane.setVgap(30);
        gridpane.setTranslateY(50);
        gridpane.setTranslateX(50);
    }

    public void createPersonalizeQuestionList()
    {
        questionListVbox = new VBox();

        Label titleLabel = new Label(UtilStringStorage.questionListTitle);
        titleLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 25));
        titleLabel.setTranslateX(250);
        questionListVbox.getChildren().add(titleLabel);

        createIndividualQuestionArea();

        gridpane.setTranslateX(50);
        questionListVbox.getChildren().add(gridpane);
    }

    public void createIndividualQuestionArea()
    {
        if(PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber() == 0)
        {
            HBox hBox = new HBox();

            Label label = new Label();
            label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
            label.setText(UtilStringStorage.noPersonalizeQuestionInList);
            hBox.getChildren().add(label);
            gridpane.add(hBox, 0, 0);
        }
        else
        {
            for (int i = 0; i < 100; i++)
            {
                String propertyQuestionKey = PersonalizeQuestionsHandler.getPropertyKeyStart() + i;
                String checkForProperty = FileUtil.getPersonalizeQuestionsFile().getProperty(propertyQuestionKey + PersonalizeQuestionsHandler.getPropertyKeyQuestion());

                if(checkForProperty != null)
                {
                    createIndividualPersonalizeQuestionArea(i, checkForProperty, propertyQuestionKey);
                }
            }
        }
    }

    public void createIndividualPersonalizeQuestionArea(int i, String checkForProperty, String propertyQuestionKey)
    {
        HBox hBox = new HBox();
        Button deleteButton = new Button();
        CustomOption.setUpTrashButton(deleteButton, UtilStringStorage.individualQuestionTooltip);
        deleteButton.setPrefSize(40, 40);
        hBox.getChildren().add(deleteButton);

        Label label = new Label();
        label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
        label.setText("Question n°" + (i+1) + " : " + checkForProperty);
        hBox.getChildren().add(label);

        setOnActionIndividualDeleteButton(deleteButton, propertyQuestionKey);

        gridpane.add(hBox, 0, i);
    }

    public void setOnActionIndividualDeleteButton(Button button, String propertyString)
    {
        button.setOnAction(event -> {
            confirmAlert.modifyConfirmAlert(UtilStringStorage.individualConfirmDelete);
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                PersonalizeQuestionsHandler.deleteIndividualQuestion(propertyString);
                PersonalizeQuestionListScene personalizeQuestionListScene = new PersonalizeQuestionListScene(new ScrollPane(), stage, achievementManager);
                stage.setScene(personalizeQuestionListScene);
            }
        });
    }

    public void createDeleteArea()
    {
        deletedAreaVbox = new VBox();
        createDeleteAllVbox();

        deletedAreaVbox.setTranslateY(60);
        mainBorderPane.setLeft(deletedAreaVbox);
    }

    public void createReturnButton() {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        mainBorderPane.setTop(buttonHbox);
        returnButton.setOnAction(event -> {
            gridpane.getChildren().clear();
            backToForgeScene();
        });
    }

    public void createBackground() {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        mainBorderPane.setBackground(new Background(backgroundImage));
    }

    public void backToForgeScene() {
        QuestionCreatorScene questionCreatorScene = new QuestionCreatorScene(new BorderPane(), stage, achievementManager);
        stage.setScene(questionCreatorScene);
    }

    public void backToMainMenu() {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }
}
