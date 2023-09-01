package View;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.IconCreator;
import model.PathUtil;

public class TrophyScene extends Scene
{
    private ImageView goldCup;
    private ImageView bronzeCup;
    private ImageView silverCup;
    public TrophyScene(BorderPane pane, TrophyHandler trophyHandler)
    {
        super(pane);
        createIcons();
        VBox cupsImages = new VBox();
        cupsImages.getChildren().add(goldCup);
        cupsImages.getChildren().add(silverCup);
        silverCup.setTranslateY(80);
        cupsImages.getChildren().add(bronzeCup);
        bronzeCup.setTranslateY(180);

        pane.setLeft(cupsImages);

        VBox nbrOfCups = new VBox();
        TextArea nbrOfGoldCup = new TextArea();
        nbrOfGoldCup.setEditable(false);
        nbrOfGoldCup.setText(String.valueOf(trophyHandler.ReadInGoldCupFile()));

        TextArea nbrOfSilverCup = new TextArea();
        nbrOfSilverCup.setEditable(false);
        nbrOfSilverCup.setText(String.valueOf(trophyHandler.ReadInSilverCupFile()));

        TextArea nbrOfBronzeCup = new TextArea();
        nbrOfBronzeCup.setEditable(false);
        nbrOfBronzeCup.setText(String.valueOf(trophyHandler.ReadInBronzeCupFile()));

        nbrOfCups.getChildren().add(nbrOfGoldCup);
        nbrOfCups.getChildren().add(nbrOfSilverCup);
        nbrOfCups.getChildren().add(nbrOfBronzeCup);
        pane.setCenter(nbrOfCups);

    }

    public void createIcons()
    {
        IconCreator goldCupImage = new IconCreator(PathUtil.GOLD_CUP_PATH);
        goldCup = goldCupImage.createImage();
        goldCup.setFitHeight(100);
        goldCup.setFitWidth(80);

        IconCreator bronzeCupImage = new IconCreator(PathUtil.BRONZE_CUP_PATH);
        bronzeCup = bronzeCupImage.createImage();
        bronzeCup.setFitHeight(100);
        bronzeCup.setFitWidth(80);

        IconCreator silverCupImage = new IconCreator(PathUtil.SILVER_CUP_PATH);
        silverCup = silverCupImage.createImage();
        silverCup.setFitHeight(100);
        silverCup.setFitWidth(80);
    }

    public void displayTrophyScene()
    {
        Stage stage = new Stage();
        stage.setTitle("Trophées");
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.setScene(this);
        stage.show();
    }
}
