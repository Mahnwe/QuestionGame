package util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IconCreator
{
    private final String imagePath;
    private InputStream stream;
    private static final Logger logger = LogManager.getLogger(IconCreator.class);

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
            logger.error("Image file can't be found");
        }
        Image image = new Image(stream);
        imageView.setImage(image);
        return imageView;
    }

    public static ImageView createCupIcon(String pathIcon)
    {
        IconCreator goldCupImage = new IconCreator(pathIcon);
        ImageView imageView = goldCupImage.createImage();
        stylizeIcon(imageView);
        return imageView;
    }

    public static void stylizeIcon(ImageView imageView)
    {
        imageView.setFitHeight(170);
        imageView.setFitWidth(150);
    }

    public static ImageView createDevImage()
    {
        IconCreator iconCreator = new IconCreator(PathUtil.DEV_LURK);
        ImageView imageView = iconCreator.createImage();
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        imageView.setTranslateX(25);
        return imageView;
    }
}
