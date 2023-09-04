package model;

import javafx.scene.image.Image;

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
}
