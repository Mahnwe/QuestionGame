package view;

import javafx.event.Event;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;
import util.CustomOption;

public class PopUp {


    public static PlayerInfoScene createPopup(Player player, BorderPane menuPane, QuestionInterface questionInterface)
    {
        PlayerInfoScene playerInfoScene = new PlayerInfoScene(new BorderPane(), player);
        Stage popUpStage = new Stage();
        popUpStage.setOnCloseRequest(Event::consume);
        popUpStage.setMinHeight(350);
        popUpStage.setMinWidth(750);
        popUpStage.setResizable(false);
        popUpStage.setTitle("Pop up");
        popUpStage.setScene(playerInfoScene);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.show();
        CustomOption.setGlowEffectOnButton(playerInfoScene.getSendButton());
        playerInfoScene.getSendButton().setOnAction(event -> playerInfoScene.setOnActionSendButton(menuPane, questionInterface, popUpStage));
        playerInfoScene.getUserInputArea().setOnKeyPressed(event -> playerInfoScene.setOnKeyTypedSendButton(menuPane, questionInterface, popUpStage));
        return playerInfoScene;
    }
}
