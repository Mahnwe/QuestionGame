package view.scene;

import javafx.animation.PauseTransition;
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
import javafx.util.Duration;
import model.AchievementManager;
import model.PersonalizeQuestionsHandler;
import util.*;
import view.customobject.QuestionCreatorTextArea;
import view.customvbox.QuestionCreatorVbox;
import view.customobject.ReturnButton;
import view.customobject.ValidateQuestionCreationButton;

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
    private final List<QuestionCreatorTextArea> textAreaList = new ArrayList<>();
    private final List<QuestionCreatorTextArea> answerTextAreaList = new ArrayList<>();
    private final ValidateQuestionCreationButton validateQuestionCreationButton;
    private Label isCreatedLabel;

    public QuestionCreatorScene(BorderPane pane, Stage stage, AchievementManager achievementManager)
    {
        super(pane);
        this.borderPane = pane;
        this.stage = stage;
        this.achievementManager = achievementManager;

        centerVbox = new VBox();
        centerVbox.setTranslateY(50);
        centerVbox.setTranslateX(50);
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
        gridPane.setHgap(40);
        gridPane.setVgap(30);
        borderPane.setCenter(multiPane);
        gridPane.setTranslateY(90);
        gridPane.setTranslateX(200);
    }

    public void createPresentation()
    {
        VBox titleFormVbox = new VBox();
        titleFormVbox.setTranslateX(500);
        titleFormVbox.setTranslateY(20);
        Label sceneTitleLabel = new Label(UtilStringStorage.creatorSceneTitleLabel);
        sceneTitleLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 40));
        titleFormVbox.getChildren().add(sceneTitleLabel);

        Label explanationLabel = new Label(UtilStringStorage.sceneExplanationLabel);
        explanationLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 30));
        titleFormVbox.getChildren().add(explanationLabel);
        explanationLabel.setTranslateY(50);
        explanationLabel.setTranslateX(-250);

        multiPane.setTop(titleFormVbox);
    }

    public void createButtons()
    {
        validateQuestionCreationButton.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 24));

        isCreatedLabel = new Label();
        isCreatedLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 24));
        isCreatedLabel.setTranslateY(120);
        isCreatedLabel.setTranslateX(500);

        centerVbox.getChildren().add(validateQuestionCreationButton);
        centerVbox.getChildren().add(isCreatedLabel);

        validateQuestionCreationButton.setTranslateY(160);
        validateQuestionCreationButton.setTranslateX(250);
    }

    public void createAreaForForm(Label label, QuestionCreatorTextArea textArea, int columnIndex, int rowIndex)
    {
        textAreaList.add(textArea);
        QuestionCreatorVbox questionCreatorVbox = new QuestionCreatorVbox(label, textArea);
        stylizeLabel(questionCreatorVbox, label, columnIndex, rowIndex);
    }

    public void createForm()
    {
        QuestionCreatorTextArea categoryTextArea = new QuestionCreatorTextArea(20);
        setUpSlotTextArea(UtilStringStorage.createCategoryLabel, categoryTextArea, 0, 0);

        QuestionCreatorTextArea questionTextArea = new QuestionCreatorTextArea(85);
        setUpSlotTextArea(UtilStringStorage.createQuestionToAskLabel, questionTextArea, 2, 0);

        QuestionCreatorTextArea answerATextArea = new QuestionCreatorTextArea(26);
        setUpSlotTextArea(UtilStringStorage.createAnswerALabel, answerATextArea, 0, 1);
        answerTextAreaList.add(answerATextArea);

        QuestionCreatorTextArea answerBTextArea = new QuestionCreatorTextArea(26);
        setUpSlotTextArea(UtilStringStorage.createAnswerBLabel, answerBTextArea, 2, 1);
        answerTextAreaList.add(answerBTextArea);

        QuestionCreatorTextArea answerCTextArea = new QuestionCreatorTextArea(26);
        setUpSlotTextArea(UtilStringStorage.createAnswerCLabel, answerCTextArea, 0, 2);
        answerTextAreaList.add(answerCTextArea);

        QuestionCreatorTextArea answerDTextArea = new QuestionCreatorTextArea(26);
        setUpSlotTextArea(UtilStringStorage.createAnswerDLabel, answerDTextArea, 2, 2);
        answerTextAreaList.add(answerDTextArea);

        QuestionCreatorTextArea goodAnswerTextArea = new QuestionCreatorTextArea(26);
        setUpSlotTextArea(UtilStringStorage.createGoodAnswerLabel, goodAnswerTextArea, 0, 3);

        QuestionCreatorTextArea explanationTextArea = new QuestionCreatorTextArea(95);
        setUpSlotTextArea(UtilStringStorage.createExplanationLabel, explanationTextArea, 2, 3);

        centerVbox.getChildren().add(gridPane);
        multiPane.setCenter(centerVbox);

        validateQuestionCreationButton.setOnAction(event -> {
            isCreatedLabel.setText("");
            validateQuestionCreationButton.checkForValidateQuestion(textAreaList);
            if(validateQuestionCreationButton.getNumberOfFilledTextArea() == 8 && ValidateQuestionCreationButton.findAnswerEqualToGoodAnswer(goodAnswerTextArea, answerTextAreaList))
            {
                PersonalizeQuestionsHandler.addNewQuestionToPropertiesFile(categoryTextArea.getText(), questionTextArea.getText(), answerATextArea.getText(), answerBTextArea.getText(),
                        answerCTextArea.getText(), answerDTextArea.getText(), goodAnswerTextArea.getText(), explanationTextArea.getText());
                setUpQuestionIsForgedLabel();
            }
            else {
                setUpQuestionIsNotForgedLabel();
            }
        });
    }

    public void setUpSlotTextArea(String slotLabel, QuestionCreatorTextArea questionCreatorTextArea, int columnIndex, int rowIndex)
    {
        Label categoryLabel = new Label(slotLabel);
        createAreaForForm(categoryLabel, questionCreatorTextArea,columnIndex, rowIndex);
    }

    public void setUpQuestionIsNotForgedLabel()
    {
        isCreatedLabel.setText(UtilStringStorage.questionIsNotForged);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
        visiblePause.setOnFinished(transitionEvent2 -> isCreatedLabel.setText(""));
        visiblePause.play();
    }

    public void setUpQuestionIsForgedLabel()
    {
        isCreatedLabel.setText(UtilStringStorage.questionIsForged);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
        visiblePause.setOnFinished(transitionEvent -> isCreatedLabel.setText(""));
        visiblePause.play();
        PersonalizeQuestionsHandler.addPersonalizeQuestionsToStringList();
        resetTextAreas();
    }

    public void createListPersonalizeQuestionButton()
    {
        VBox vBox = new VBox();
        vBox.setMaxHeight(200);
        vBox.setBorder(CustomOption.createCustomBorder(3.0, 1.5, Color.BLACK));

        Label personalizeListLabel = new Label(UtilStringStorage.personalizeQuestionListLabel);
        personalizeListLabel.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 26));
        vBox.getChildren().add(personalizeListLabel);

        Button personalizeQuestionList = new Button();
        Tooltip buttonTooltip = new Tooltip(UtilStringStorage.personalizeListButtonTooltip);
        buttonTooltip.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 20));
        personalizeQuestionList.setTooltip(buttonTooltip);
        personalizeQuestionList.setPrefSize(130, 130);

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
        vBox.setTranslateY(230);
        vBox.setTranslateX(-230);
    }

    public void resetTextAreas() {
        for (QuestionCreatorTextArea questionCreatorTextArea : textAreaList) {
            questionCreatorTextArea.clear();
            questionCreatorTextArea.setFill(false);
            questionCreatorTextArea.setBorder(CustomOption.createCustomBorder(1.5, 2.0, Color.BLACK));
        }
    }
    public void stylizeLabel(VBox vBox, Label label, int columnIndex, int rowIndex) {
        label.setFont(Font.font(POLICE_LABEL, FontWeight.BOLD, 22));
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
