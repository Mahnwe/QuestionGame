package model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundManager {

    public static Double soundVolume = 5.0;
    public static MediaPlayer playMusic(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(soundVolume /10);
        mediaPlayer.play();
        return mediaPlayer;
    }

    public static MediaPlayer playMusicRepeat(String pathSound)
    {
        Media media = new Media(new File(pathSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(soundVolume /10);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(12000);
        return mediaPlayer;
    }

    public static void handleMenuSceneVolume(MediaPlayer mediaPlayer, Double mediaVolume)
    {
        mediaPlayer.setVolume(mediaVolume/10);
    }

    public static void stopMusic(MediaPlayer mediaPlayer)
    {
        mediaPlayer.stop();
    }

    public static void checkIfMusicIsPlayed(MediaPlayer mediaPlayer)
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
        }
    }

    public static void setSoundVolume(Double soundVolume) {
        SoundManager.soundVolume = soundVolume;
    }
}
