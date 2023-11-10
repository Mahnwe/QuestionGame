package util;

import javafx.scene.image.ImageView;

public class GifCreator {

    public static ImageView createVibeGif(int translateX, int translateY)
    {
        IconCreator iconCreator = new IconCreator(PathUtil.VIBE_GIF);
        ImageView imageView = iconCreator.createImage();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setTranslateX(translateX);
        imageView.setTranslateY(translateY);
        return imageView;
    }
}
