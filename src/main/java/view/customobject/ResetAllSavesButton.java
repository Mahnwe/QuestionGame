package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.handlers.AchievementManager;
import model.TimePlayedTimer;
import util.FileUtil;
import util.JsonFileUtil;
import util.stringutiltranslate.UtilStringStorage;
import view.scene.MenuScene;

import java.util.Optional;

public class ResetAllSavesButton extends Button {

    public ResetAllSavesButton(ConfirmAlert confirmAlert, Stage stage)
    {
        this.setTranslateY(205);
        this.setTranslateX(410);

        CustomOption.setUpTrashButton(this, UtilStringStorage.resetTooltip);

        this.setOnAction(event ->
        {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                TimePlayedTimer.stopTimer();
                JsonFileUtil.resetJsonFile();
                FileUtil.resetGeneralSavesFile();
                TimePlayedTimer.startTimer();
                MenuScene menuScene = new MenuScene(new BorderPane(), stage, new AchievementManager());
                stage.setScene(menuScene);
            }
        });
    }
}
