package model.handlers;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import view.App;
import view.scene.MainScene;

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
                soundVolume = 0.0;
                handleMenuSceneVolume(App.menuMusicToStop, 0.0);
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
        handleMenuSceneVolume(App.menuMusicToStop, sliderValue);
        setSoundVolume(sliderValue);
    }

    public static void setUpMuteButtonInGame(Button button, Slider volumeSlider)
    {
        button.setOnAction(event -> {
            if (!isMute) {
                soundVolume = 0.0;
                handleMenuSceneVolume(MainScene.inGameMusicToStop, 0.0);
                isMute = true;
                volumeSlider.setDisable(true);
            }
            else {
                volumeSlider.setDisable(false);
                setVolumeFromSliderInGame(volumeSlider.getValue());
                isMute = false;
            }
        });
    }

    public static void setVolumeFromSliderInGame(Double sliderValue)
    {
        handleMenuSceneVolume(MainScene.inGameMusicToStop, sliderValue);
        setSoundVolume(sliderValue);
    }

    public static void setSoundVolume(Double soundVolume) {
        SoundManager.soundVolume = soundVolume;
    }
}
