package view;

import javafx.event.Event;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;
import util.CustomOption;

public class PopUp {


    public static PlayerInfoScene createPopup(Player player, BorderPane menuPane, QuestionInterface questionInterface, Stage stage)
    {
        PlayerInfoScene playerInfoScene = new PlayerInfoScene(new BorderPane(), player);
        Stage popUpStage = new Stage();
        popUpStage.setOnCloseRequest(Event::consume);
        popUpStage.setMinHeight(300);
        popUpStage.setMinWidth(550);
        popUpStage.setResizable(false);
        popUpStage.setTitle("Pop up");
        popUpStage.setScene(playerInfoScene);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.show();
        CustomOption.setGlowEffectOnButton(playerInfoScene.getSendButton());
        playerInfoScene.getSendButton().setOnAction(event -> playerInfoScene.setOnActionSendButton(menuPane, questionInterface, stage, popUpStage));
        playerInfoScene.getUserInputArea().setOnKeyPressed(event -> playerInfoScene.setOnKeyTypedSendButton(menuPane, questionInterface, stage, popUpStage));
        return playerInfoScene;
    }
}
