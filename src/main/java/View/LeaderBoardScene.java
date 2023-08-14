package View;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderBoardScene extends Scene
{

    private String line;
    private final File saveFile;

    public LeaderBoardScene(BorderPane pane, File saveFile)
    {
        super(pane);
        this.saveFile = saveFile;
        readFile();
        VBox leaderBoardVBox = new VBox();
        TextArea leaderBoardArea = new TextArea(line);
        leaderBoardVBox.getChildren().add(leaderBoardArea);
        pane.setCenter(leaderBoardVBox);
    }

    public void readFile()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
            line = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
