package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AchievementManager;
import model.PersonalizeQuestionsHandler;
import util.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionCreatorScene extends Scene {
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

    public QuestionCreatorScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.borderPane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;

        centerVbox = new VBox();
        validateQuestionCreationButton = new ValidateQuestionCreationButton();

        createGridPane();

        createReturnButton();
        createBackground();
        createPresentation();
        createForm();
        createButtons();
        createListPersonalizeQuestionButton();
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
        isCreatedLabel.setTranslateY(50);
        isCreatedLabel.setTranslateX(450);

        centerVbox.getChildren().add(validateQuestionCreationButton);
        centerVbox.getChildren().add(isCreatedLabel);

        validateQuestionCreationButton.setTranslateY(90);
        validateQuestionCreationButton.setTranslateX(200);
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

    public void createListPersonalizeQuestionButton()
    {
        VBox vBox = new VBox();
        vBox.setMaxHeight(200);
        vBox.setBorder(CustomOption.createCustomBorder(3.0, 1.5, Color.BLACK));

        Label personalizeListLabel = new Label(UtilStringStorage.personalizeQuestionListLabel);
        personalizeListLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
        vBox.getChildren().add(personalizeListLabel);

        Button personalizeQuestionList = new Button();
        Tooltip buttonTooltip = new Tooltip(UtilStringStorage.personalizeListButtonTooltip);
        personalizeQuestionList.setTooltip(buttonTooltip);
        personalizeQuestionList.setPrefSize(110, 110);

        IconCreator personalizeIcon = new IconCreator(PathUtil.PERSONALIZE_LIST);
        ImageView personalizeImage = personalizeIcon.createImage();

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        personalizeQuestionList.setBackground(new Background(new BackgroundImage(personalizeImage.getImage(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        CustomOption.setGlowEffectOnButton(personalizeQuestionList);

        personalizeQuestionList.setOnAction(event -> {
            resetTextAreas();
            PersonalizeQuestionListScene personalizeQuestionListScene = new PersonalizeQuestionListScene(new ScrollPane(), stage, achievementManager);
            stage.setScene(personalizeQuestionListScene);
        });

        vBox.getChildren().add(personalizeQuestionList);
        multiPane.setRight(vBox);
        vBox.setTranslateY(110);
        vBox.setTranslateX(-60);
    }

    public void resetTextAreas() {
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList) {
            questionCreatorTextArea.clear();
            questionCreatorTextArea.setFill(false);
            questionCreatorTextArea.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.BLACK));
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
