package util;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BackgroundCreator
{
    private final String backgroundImagePath;
    private Image image;
    private InputStream stream;

    public BackgroundCreator (String backgroundImagePath)
    {
        this.stream = null;
        this.backgroundImagePath = backgroundImagePath;
    }

    public Image createBackground()
    {
        try
        {
            stream = new FileInputStream(backgroundImagePath);
            image = new Image(stream);
        } catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.printStackTrace();
        }
        return image;
    }

    public static BackgroundImage createMenuBackground()
    {
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        BackgroundCreator menuBackground = new BackgroundCreator(PathUtil.MENU_BACKGROUND);
        Image menuSceneBackground = menuBackground.createBackground();
        return new BackgroundImage(menuSceneBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
    }

    public static BackgroundFill createGameBackground()
    {
        BackgroundCreator mainSceneBackgroundCreator = new BackgroundCreator(PathUtil.MAIN_BACKGROUND);
        Image mainSceneImage = mainSceneBackgroundCreator.createBackground();
        return new BackgroundFill(new ImagePattern(mainSceneImage), CornerRadii.EMPTY, Insets.EMPTY);
    }
}
