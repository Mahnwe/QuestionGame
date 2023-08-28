package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IconCreator
{
    private final String imagePath;
    private InputStream stream;

    public IconCreator (String imagePath)
    {
        this.stream = null;
        this.imagePath = imagePath;
    }

    public ImageView createImage()
    {
        ImageView imageView = new ImageView();
        try {
            stream = new FileInputStream(imagePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(stream);
        imageView.setImage(image);
        return imageView;
    }
}
