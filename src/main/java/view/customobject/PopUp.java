package view.customobject;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import model.handlers.PlayerHandler;
import model.handlers.SoundManager;
import util.PathUtil;
import util.stringutiltranslate.UtilStringStorage;
import view.App;
import view.scene.MainScene;
import view.scene.MenuScene;
import view.scene.PlayerInfoScene;
import view.scene.QuestionInterface;

import java.util.Optional;

public class PopUp
{
    private static Stage stage;
    private static AchievementManager achievementManager;


    public static PlayerInfoScene createPopup(PlayerHandler playerHandler, BorderPane menuPane, QuestionInterface questionInterface, Stage stage, AchievementManager achievementManager)
    {
        PopUp.stage = stage;
        PopUp.achievementManager = achievementManager;
        PlayerInfoScene playerInfoScene = new PlayerInfoScene(new BorderPane(), playerHandler);
        Stage popUpStage = new Stage();

        popUpStage.setOnCloseRequest(PopUp::backToMainMenu);
        popUpStage.setMinHeight(350);
        popUpStage.setMinWidth(750);
        popUpStage.setResizable(false);
        popUpStage.setTitle("Pop up");
        popUpStage.setScene(playerInfoScene);
        popUpStage.initModality(Modality.APPLICATION_MODAL);

        popUpStage.show();

        CustomOption.setGlowEffectOnButton(playerInfoScene.getSendNameButton());

        playerInfoScene.getSendNameButton().setOnAction(event -> playerInfoScene.setOnClickSendButton(menuPane, questionInterface, popUpStage));
        playerInfoScene.getUserInputArea().setOnKeyPressed(event -> playerInfoScene.setOnKeyTypedSendButton(menuPane, questionInterface, popUpStage));

        return playerInfoScene;
    }

    public static void backToMainMenu(Event event)
    {
        ConfirmAlert confirmAlert = new ConfirmAlert(Alert.AlertType.CONFIRMATION);
        confirmAlert.modifyConfirmAlert(UtilStringStorage.returnMenuConfirmAlert);
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if(result.orElse(null) == ButtonType.OK) {
            SoundManager.stopMusic(MainScene.inGameMusicToStop);
            MainScene.inGameMusicToStop.stop();
            App.menuMusicToStop = SoundManager.playMusicRepeat(PathUtil.MENU_MUSIC);
            MenuScene menuScene = new MenuScene(new BorderPane(), stage, achievementManager);
            stage.setScene(menuScene);
        }
        else {
            event.consume();
        }
    }
}
