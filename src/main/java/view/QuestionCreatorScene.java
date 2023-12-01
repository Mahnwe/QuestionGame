package view;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionCreatorScene extends Scene {

    private final ConfirmAlert confirmAlert;
    private final BorderPane borderPane;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private GridPane gridPane;
    private final BorderPane multiPane = new BorderPane();
    public static final String POLICE_LABEL = "Futura";
    private final VBox centerVbox;
    public static List<QuestionCreatorTextArea> textAreaList = new ArrayList<>();
    private final ValidateQuestionCreationButton validateQuestionCreationButton;
    private Label isCreatedLabel;
    private VBox deletedAreaVbox;

    public QuestionCreatorScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.borderPane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;
        this.confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);

        centerVbox = new VBox();
        validateQuestionCreationButton = new ValidateQuestionCreationButton();

        createGridPane();

        createReturnButton();
        createBackground();
        createPresentation();
        createForm();
        createButtons();
        createDeleteArea();

    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.addRow(7);
        gridPane.addColumn(5);
        gridPane.setHgap(30);
        gridPane.setVgap(20);
        borderPane.setCenter(multiPane);
        gridPane.setTranslateY(40);
        gridPane.setTranslateX(20);
    }

    public void createPresentation()
    {
        VBox titleFormVbox = new VBox();
        titleFormVbox.setTranslateX(450);
        Label sceneTitleLabel = new Label(UtilStringStorage.creatorSceneTitleLabel);
        sceneTitleLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 35));
        titleFormVbox.getChildren().add(sceneTitleLabel);

        Label explanationLabel = new Label(UtilStringStorage.sceneExplanationLabel);
        explanationLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 25));
        titleFormVbox.getChildren().add(explanationLabel);
        explanationLabel.setTranslateY(20);
        explanationLabel.setTranslateX(-250);

        multiPane.setTop(titleFormVbox);
    }

    public void createButtons()
    {
        validateQuestionCreationButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));

        isCreatedLabel = new Label();
        isCreatedLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));

        centerVbox.getChildren().add(validateQuestionCreationButton);
        centerVbox.getChildren().add(isCreatedLabel);

        validateQuestionCreationButton.setTranslateY(90);
        validateQuestionCreationButton.setTranslateX(200);

        isCreatedLabel.setTranslateY(50);
        isCreatedLabel.setTranslateX(450);
    }

    public void createAreaForForm(Label label, QuestionCreatorTextArea textArea, int columnIndex, int rowIndex)
    {
        textAreaList.add(textArea);
        QuestionCreatorVbox questionCreatorVbox = new QuestionCreatorVbox(label, textArea);
        stylizeLabel(questionCreatorVbox, label, columnIndex, rowIndex);
    }

    public void createForm()
    {
        Label categoryLabel = new Label(UtilStringStorage.createCategoryLabel);
        QuestionCreatorTextArea categoryTextArea = new QuestionCreatorTextArea(20);
        createAreaForForm(categoryLabel, categoryTextArea,0, 0);

        Label questionToAskLabel = new Label(UtilStringStorage.createQuestionToAskLabel);
        QuestionCreatorTextArea questionTextArea = new QuestionCreatorTextArea(85);
        createAreaForForm(questionToAskLabel, questionTextArea, 2, 0);

        Label createAnswerALabel = new Label(UtilStringStorage.createAnswerALabel);
        QuestionCreatorTextArea answerATextArea = new QuestionCreatorTextArea(26);
        createAreaForForm(createAnswerALabel, answerATextArea, 0, 1);

        Label createAnswerBLabel = new Label(UtilStringStorage.createAnswerBLabel);
        QuestionCreatorTextArea answerBTextArea = new QuestionCreatorTextArea(26);
        createAreaForForm(createAnswerBLabel, answerBTextArea, 2, 1);

        Label createAnswerCLabel = new Label(UtilStringStorage.createAnswerCLabel);
        QuestionCreatorTextArea answerCTextArea = new QuestionCreatorTextArea(26);
        createAreaForForm(createAnswerCLabel, answerCTextArea, 0, 2);

        Label createAnswerDLabel = new Label(UtilStringStorage.createAnswerDLabel);
        QuestionCreatorTextArea answerDTextArea = new QuestionCreatorTextArea(26);
        createAreaForForm(createAnswerDLabel,answerDTextArea, 2, 2);

        Label createGoodAnswerLabel = new Label(UtilStringStorage.createGoodAnswerLabel);
        QuestionCreatorTextArea goodAnswerTextArea = new QuestionCreatorTextArea(26);
        createAreaForForm(createGoodAnswerLabel, goodAnswerTextArea, 0, 3);

        Label createExplanationLabel = new Label(UtilStringStorage.createExplanationLabel);
        QuestionCreatorTextArea explanationTextArea = new QuestionCreatorTextArea(95);
        createAreaForForm(createExplanationLabel, explanationTextArea, 2, 3);

        centerVbox.getChildren().add(gridPane);
        multiPane.setCenter(centerVbox);

        validateQuestionCreationButton.setOnAction(event -> {
            isCreatedLabel.setText("");
            validateQuestionCreationButton.checkForValidateQuestion(textAreaList);
            if(validateQuestionCreationButton.getNumberOfFilledTextArea() == 8)
            {
                PersonalizeQuestionsHandler.addNewQuestionToPropertiesFile(categoryTextArea.getText(), questionTextArea.getText(), answerATextArea.getText(), answerBTextArea.getText(),
                        answerCTextArea.getText(), answerDTextArea.getText(), goodAnswerTextArea.getText(), explanationTextArea.getText());
                isCreatedLabel.setText(UtilStringStorage.questionIsForged);
                PersonalizeQuestionsHandler.addPersonalizeQuestionsToStringList();
                resetTextAreas();
            }
            else {
                isCreatedLabel.setText(UtilStringStorage.questionIsNotForged);
            }
        });
    }

    public void createDeleteAllVbox()
    {
        VBox deleteAllVbox = new VBox();
        Label deleteAllLabel = new Label(UtilStringStorage.deleteAllLabel);
        deleteAllLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));

        Button deleteAllPersonalizeQuestionsButton = new Button();
        CustomOption.setUpTrashButton(deleteAllPersonalizeQuestionsButton, UtilStringStorage.deleteAllTooltip);

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
                    questionsAreDeletedLabel.setVisible(true);
                } else {
                    questionsAreDeletedLabel.setText(UtilStringStorage.nothingToDelete);
                    questionsAreDeletedLabel.setVisible(true);
                }
            }
        });
        deleteAllVbox.getChildren().add(deleteAllLabel);
        deleteAllVbox.getChildren().add(deleteAllPersonalizeQuestionsButton);
        deleteAllVbox.getChildren().add(questionsAreDeletedLabel);
        deletedAreaVbox.getChildren().add(deleteAllVbox);
    }

    public void createDeleteLastVbox()
    {
        VBox deleteLastVbox = new VBox();

        Label deleteLastQuestionLabel = new Label(UtilStringStorage.deleteLastLabel);
        deleteLastQuestionLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));

        Button deleteLastPersonalizeQuestionsButton = new Button();
        CustomOption.setUpTrashButton(deleteLastPersonalizeQuestionsButton, UtilStringStorage.deleteLastTooltip);

        Label lastQuestionIsDeletedLabel = new Label(UtilStringStorage.lastQuestionIsDeleted);
        lastQuestionIsDeletedLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));
        lastQuestionIsDeletedLabel.setVisible(false);

        deleteLastPersonalizeQuestionsButton.setOnAction(event -> {
            lastQuestionIsDeletedLabel.setText(UtilStringStorage.deleteLastLabel);
            confirmAlert.modifyConfirmAlert(UtilStringStorage.confirmLastQuestionIsDeleted);
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK) {
                if (PersonalizeQuestionsHandler.getPropertyKeyQuestionNumber() > 0)
                {
                    PersonalizeQuestionsHandler.deleteLastQuestionAdded();
                    lastQuestionIsDeletedLabel.setVisible(true);
                }
                else {
                    lastQuestionIsDeletedLabel.setText(UtilStringStorage.nothingToDelete);
                    lastQuestionIsDeletedLabel.setVisible(true);
                }
            }
        });
        deleteLastVbox.getChildren().add(deleteLastQuestionLabel);
        deleteLastVbox.getChildren().add(deleteLastPersonalizeQuestionsButton);
        deleteLastVbox.getChildren().add(lastQuestionIsDeletedLabel);
        deleteLastVbox.setTranslateY(20);
        deletedAreaVbox.getChildren().add(deleteLastVbox);
    }

    public void createDeleteArea()
    {
        deletedAreaVbox = new VBox();

        createDeleteAllVbox();
        createDeleteLastVbox();

        deletedAreaVbox.setTranslateY(60);
        deletedAreaVbox.setTranslateX(-40);

        multiPane.setRight(deletedAreaVbox);
    }

    public void resetTextAreas() {
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList) {
            questionCreatorTextArea.clear();
            questionCreatorTextArea.setFill(false);
        }
    }

    public void stylizeLabel(VBox vBox, Label label, int columnIndex, int rowIndex) {
        label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));
        gridPane.add(vBox, columnIndex, rowIndex);
    }

    public void createReturnButton() {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        borderPane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createBackground() {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        borderPane.setBackground(new Background(backgroundImage));
    }

    public void backToMainMenu() {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }

}
