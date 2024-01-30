package view;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AchievementManager;
import model.TimePlayedTimer;
import util.CustomOption;
import util.FileUtil;
import util.UtilStringStorage;

import java.util.Optional;

public class ResetAllSavesButton extends Button {

    public ResetAllSavesButton(ConfirmAlert confirmAlert, Stage stage)
    {
        this.setTranslateY(105);
        this.setTranslateX(410);

        CustomOption.setUpTrashButton(this, UtilStringStorage.resetTooltip);

        this.setOnAction(event -> {
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if(result.orElse(null) == ButtonType.OK)
            {
                TimePlayedTimer.stopTimer();
                FileUtil.resetSaveFile();
                FileUtil.resetGeneralSavesFile();
                TimePlayedTimer.startTimer();
                MenuScene menuScene = new MenuScene(new BorderPane(), stage, new AchievementManager());
                stage.setScene(menuScene);
            }
        });
    }
}
