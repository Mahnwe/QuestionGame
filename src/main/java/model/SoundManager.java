package model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundManager {

    public static int soundVolume;
    public static MediaPlayer playMusic(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(soundVolume);
        mediaPlayer.play();
        return mediaPlayer;
    }

    public static MediaPlayer playMusicRepeat(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume((double) soundVolume /10);
        mediaPlayer.setAutoPlay(true);
        return mediaPlayer;
    }

    public static void stopMusic(MediaPlayer mediaPlayer)
    {
        mediaPlayer.stop();
    }


    public static void setSoundVolume(int soundVolume) {
        SoundManager.soundVolume = soundVolume;
    }
}
