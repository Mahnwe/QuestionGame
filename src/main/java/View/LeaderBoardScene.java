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

    private final File saveFile;

    private StringBuilder stringBuilder;

    public LeaderBoardScene(BorderPane pane, File saveFile)
    {
        super(pane);
        this.saveFile = saveFile;
        readFile();
        VBox leaderBoardVBox = new VBox();
        TextArea leaderBoardArea = new TextArea();
        leaderBoardArea.setText(String.valueOf(stringBuilder));
        leaderBoardVBox.getChildren().add(leaderBoardArea);
        leaderBoardArea.setEditable(false);
        pane.setCenter(leaderBoardVBox);
    }

    public void readFile()
    {
        stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
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
