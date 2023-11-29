package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import util.BackgroundCreator;
import util.UtilStringStorage;

import java.util.ArrayList;
import java.util.List;

public class QuestionCreatorScene extends Scene {
    private final BorderPane borderPane;
    private final Stage stage;
    private final AchievementManager achievementManager;
    private GridPane gridPane;
    private final BorderPane multiPane = new BorderPane();
    public static final String POLICE_LABEL = "Futura";
    private VBox centerVbox;
    public static List<QuestionCreatorTextArea> textAreaList = new ArrayList<>();

    public QuestionCreatorScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.borderPane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;

        createGridPane();

        createReturnButton();
        createBackground();
        createPresentation();
        createForm();
        createButtons();


    }

    public void createGridPane()
    {
        gridPane = new GridPane();
        gridPane.addRow(7);
        gridPane.addColumn(5);
        gridPane.setHgap(50);
        gridPane.setVgap(20);
        borderPane.setCenter(multiPane);
        gridPane.setTranslateY(40);
        gridPane.setTranslateX(120);
    }

    public void createPresentation()
    {
        VBox titleFormVbox = new VBox();
        titleFormVbox.setTranslateX(400);
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
        ValidateQuestionCreationButton validateQuestionCreationButton = new ValidateQuestionCreationButton();
        validateQuestionCreationButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));

        Button checkButton = new Button("Check");
        checkButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));

        centerVbox.getChildren().add(validateQuestionCreationButton);
        centerVbox.getChildren().add(checkButton);

        validateQuestionCreationButton.setTranslateY(90);
        validateQuestionCreationButton.setTranslateX(580);

        checkButton.setTranslateY(50);
        checkButton.setTranslateX(380);

        checkButton.setOnAction(event -> {
            validateQuestionCreationButton.checkForValidateQuestion(textAreaList);
            if(validateQuestionCreationButton.getNumberOfFilledTextArea() == 8)
            {
                validateQuestionCreationButton.setDisable(false);
            }
        });
    }

    public void createForm()
    {
        centerVbox = new VBox();

        Label categoryLabel = new Label(UtilStringStorage.createCategoryLabel);
        QuestionCreatorTextArea categoryTextArea = new QuestionCreatorTextArea(20);
        textAreaList.add(categoryTextArea);
        QuestionCreatorVbox categoryVbox = new QuestionCreatorVbox(categoryLabel, categoryTextArea);
        stylizeLabel(categoryVbox, categoryLabel, 0, 0);

        Label questionToAskLabel = new Label(UtilStringStorage.createQuestionToAskLabel);
        QuestionCreatorTextArea questionTextArea = new QuestionCreatorTextArea(85);
        textAreaList.add(questionTextArea);
        QuestionCreatorVbox questionVbox = new QuestionCreatorVbox(questionToAskLabel, questionTextArea);
        stylizeLabel(questionVbox, questionToAskLabel, 2, 0);

        Label createAnswerALabel = new Label(UtilStringStorage.createAnswerALabel);
        QuestionCreatorTextArea answerATextArea = new QuestionCreatorTextArea(26);
        textAreaList.add(answerATextArea);
        QuestionCreatorVbox answerAVbox = new QuestionCreatorVbox(createAnswerALabel, answerATextArea);
        stylizeLabel(answerAVbox, createAnswerALabel, 0, 1);

        Label createAnswerBLabel = new Label(UtilStringStorage.createAnswerBLabel);
        QuestionCreatorTextArea answerBTextArea = new QuestionCreatorTextArea(26);
        textAreaList.add(answerBTextArea);
        QuestionCreatorVbox answerBVbox = new QuestionCreatorVbox(createAnswerBLabel, answerBTextArea);
        stylizeLabel(answerBVbox, createAnswerBLabel, 2, 1);

        Label createAnswerCLabel = new Label(UtilStringStorage.createAnswerCLabel);
        QuestionCreatorTextArea answerCTextArea = new QuestionCreatorTextArea(26);
        textAreaList.add(answerCTextArea);
        QuestionCreatorVbox answerCVbox = new QuestionCreatorVbox(createAnswerCLabel, answerCTextArea);
        stylizeLabel(answerCVbox, createAnswerCLabel, 0, 2);

        Label createAnswerDLabel = new Label(UtilStringStorage.createAnswerDLabel);
        QuestionCreatorTextArea answerDTextArea = new QuestionCreatorTextArea(26);
        textAreaList.add(answerDTextArea);
        QuestionCreatorVbox answerDVbox = new QuestionCreatorVbox(createAnswerDLabel, answerDTextArea);
        stylizeLabel(answerDVbox, createAnswerDLabel, 2, 2);

        Label createGoodAnswerLabel = new Label(UtilStringStorage.createGoodAnswerLabel);
        QuestionCreatorTextArea goodAnswerTextArea = new QuestionCreatorTextArea(26);
        textAreaList.add(goodAnswerTextArea);
        QuestionCreatorVbox goodAnswerVbox = new QuestionCreatorVbox(createGoodAnswerLabel, goodAnswerTextArea);
        stylizeLabel(goodAnswerVbox, createGoodAnswerLabel, 0, 3);

        Label createExplanationLabel = new Label(UtilStringStorage.createExplanationLabel);
        QuestionCreatorTextArea explanationTextArea = new QuestionCreatorTextArea(95);
        textAreaList.add(explanationTextArea);
        QuestionCreatorVbox explanationVbox = new QuestionCreatorVbox(createExplanationLabel, explanationTextArea);
        stylizeLabel(explanationVbox, createExplanationLabel, 2, 3);

        centerVbox.getChildren().add(gridPane);

        multiPane.setCenter(centerVbox);
    }

    public void stylizeLabel(VBox vBox, Label label, int columnIndex, int rowIndex)
    {
        label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 18));
        gridPane.add(vBox, columnIndex, rowIndex);
    }

    public void createReturnButton()
    {
        HBox buttonHbox = new HBox();
        ReturnButton returnButton = new ReturnButton();
        buttonHbox.getChildren().add(returnButton);
        borderPane.setTop(buttonHbox);
        returnButton.setOnAction(event -> backToMainMenu());
    }

    public void createBackground()
    {
        BackgroundImage backgroundImage = BackgroundCreator.createMenuBackground();
        borderPane.setBackground(new Background(backgroundImage));
    }

    public void backToMainMenu()
    {
        MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
        stage.setScene(menuScene);
    }

}
