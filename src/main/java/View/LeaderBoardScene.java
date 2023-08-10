package View;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LeaderBoardScene extends Scene
{
    TextArea leaderBoardArea;
    private final SaveFile saveFile;

    public LeaderBoardScene(BorderPane pane, SaveFile saveFile)
    {
        super(pane);
        this.saveFile = saveFile;
        VBox leaderBoardVBox = new VBox();
        leaderBoardArea = new TextArea();
        leaderBoardVBox.getChildren().add(leaderBoardArea);
        pane.setCenter(leaderBoardVBox);
    }

    public void readFile()
    {
        leaderBoardArea.setText(saveFile.getScoreArea().getText());
    }

    public void displayLeaderBoard()
    {
        Stage stage = new Stage();
        stage.setTitle("LeaderBoard");
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.setScene(this);
        stage.show();
    }

}
