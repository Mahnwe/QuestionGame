package model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundManager {

    public static MediaPlayer playMusic(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        return mediaPlayer;
    }

    public static MediaPlayer playMusicRepeat(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        return mediaPlayer;
    }

    public static void stopMusic(MediaPlayer mediaPlayer)
    {
        mediaPlayer.stop();
    }
}
