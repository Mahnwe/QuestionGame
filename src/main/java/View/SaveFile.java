package View;

import javafx.scene.control.TextArea;

public class SaveFile {
    private final TextArea scoreArea;
    public SaveFile()
    {
        scoreArea = new TextArea();
        scoreArea.setText("LeaderBoard : ");
    }

    public TextArea getScoreArea() {
        return scoreArea;
    }
}
