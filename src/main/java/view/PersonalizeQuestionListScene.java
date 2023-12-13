package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.PersonalizeQuestionsHandler;
import util.BackgroundCreator;
import util.CustomOption;
import util.FileUtil;
import util.UtilStringStorage;

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

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);

        scrollPane.setContent(mainBorderPane);

        createReturnButton();
        createBackground();
        createDeleteArea();
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

        deleteAllPersonalizeQuestionsButton.setOnAction(event -> {
            questionsAreDeletedLabel.setText(UtilStringStorage.questionAreDeleted);
            confirmAlert.modifyConfirmAlert(UtilStringStorage.confirmAlertDeleteAllQuestions);
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                if(PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber() > 0) {
                    FileUtil.resetPersonalizeQuestionFile();
                    backToMainMenu();
                    questionsAreDeletedLabel.setVisible(true);
                } else {
                    questionsAreDeletedLabel.setText(UtilStringStorage.nothingToDelete);
                    questionsAreDeletedLabel.setVisible(true);
                }
                gridpane.getChildren().clear();
            }
        });
        deleteAllVbox.getChildren().add(deleteAllLabel);
        deleteAllVbox.getChildren().add(deleteAllPersonalizeQuestionsButton);
        deleteAllVbox.getChildren().add(questionsAreDeletedLabel);
        deletedAreaVbox.getChildren().add(deleteAllVbox);
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
        createGridPaneList();
        questionListVbox = new VBox();

        Label titleLabel = new Label(UtilStringStorage.questionListTitle);
        titleLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 25));
        titleLabel.setTranslateX(250);
        questionListVbox.getChildren().add(titleLabel);

        if(PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber() == 0) {
            Label label = new Label();
            label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
            label.setText(UtilStringStorage.noPersonalizeQuestionInList);
            gridpane.add(label, 0, 0);
        }
        else {
            for (int i = 0; i < PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber(); i++) {
                int deleteIndex = i;
                String propertyQuestionKey = PersonalizeQuestionsHandler.getPropertyKeyStart() + deleteIndex;

                HBox hBox = new HBox();
                Button deleteButton = new Button();
                CustomOption.setUpTrashButton(deleteButton, "Delete this question from list");
                deleteButton.setPrefSize(40, 40);
                hBox.getChildren().add(deleteButton);

                Label label = new Label();
                label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));

                if(FileUtil.personalizeQuestionsFile.getProperty(propertyQuestionKey + PersonalizeQuestionsHandler.getPropertyKeyQuestion()) != null)
                {
                    String checkForProperty = FileUtil.personalizeQuestionsFile.getProperty(propertyQuestionKey + PersonalizeQuestionsHandler.getPropertyKeyQuestion());
                    label.setText("Question n°" + (i+1) + " : " + checkForProperty);

                    deleteButton.setOnAction(event -> {
                        confirmAlert.modifyConfirmAlert("Etes vous sûr de vouloir supprimer cette question ?");
                        Optional<ButtonType> result = confirmAlert.showAndWait();
                        if(result.orElse(null) == ButtonType.OK) {
                            PersonalizeQuestionsHandler.deleteIndividualQuestion(propertyQuestionKey);
                            gridpane.getChildren().remove(deleteIndex);
                        }
                    });
                }
                else
                {
                    int deleteIndexSup = deleteIndex;
                    String propertyQuestionKeyNotFind;
                    String checkForProperty;
                    do {
                        propertyQuestionKeyNotFind = PersonalizeQuestionsHandler.getPropertyKeyStart() + deleteIndexSup;
                        checkForProperty = FileUtil.personalizeQuestionsFile.getProperty(propertyQuestionKeyNotFind + PersonalizeQuestionsHandler.getPropertyKeyQuestion());
                        deleteIndexSup++;
                    }while(checkForProperty == null);

                    label.setText("Question n°" + (i + 1) + " : " + checkForProperty);
                    String finalPropertyQuestionKeyNotFind = propertyQuestionKeyNotFind;

                    deleteButton.setOnAction(event -> {
                            confirmAlert.modifyConfirmAlert("Etes vous sûr de vouloir supprimer cette question ?");
                            Optional<ButtonType> result = confirmAlert.showAndWait();
                            if (result.orElse(null) == ButtonType.OK) {
                                PersonalizeQuestionsHandler.deleteIndividualQuestion(finalPropertyQuestionKeyNotFind);
                                gridpane.getChildren().remove(deleteIndex);
                            }
                        });
                }
                hBox.getChildren().add(label);
                gridpane.add(hBox, 0, i);
            }
        }
        gridpane.setTranslateX(50);
        questionListVbox.getChildren().add(gridpane);
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
