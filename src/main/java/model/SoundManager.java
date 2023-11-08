package model;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import view.App;
import view.ResultScene;

import java.io.File;

public class SoundManager {

    public static boolean isMute;
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

    public static void setUpMuteButton(Button button, Slider volumeSlider)
    {
        button.setOnAction(event -> {
            if (!isMute) {
                SoundManager.soundVolume = 0.0;
                SoundManager.handleMenuSceneVolume(App.menuMusicToStop, 0.0);
                if(ResultScene.returnToMenuMusic != null) {
                    SoundManager.handleMenuSceneVolume(ResultScene.returnToMenuMusic, 0.0);
                }
                isMute = true;
                volumeSlider.setDisable(true);
            }
            else {
                volumeSlider.setDisable(false);
                setVolumeFromSlider(volumeSlider.getValue());
                isMute = false;
            }
        });
    }

    public static void setVolumeFromSlider(Double sliderValue)
    {
        SoundManager.handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
        SoundManager.setSoundVolume(sliderValue);
    }

    public static void setSoundVolume(Double soundVolume) {
        SoundManager.soundVolume = soundVolume;
    }
}
