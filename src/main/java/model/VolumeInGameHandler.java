package model;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import view.MainScene;

public class VolumeInGameHandler
{
    public static boolean isMute;

    public static void setUpMuteButton(Button button, Slider volumeSlider)
    {
        button.setOnAction(event -> {
            if (!isMute) {
                SoundManager.soundVolume = 0.0;
                SoundManager.handleMenuSceneVolume(MainScene.inGameMusicToStop, 0.0);
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
        SoundManager.handleMenuSceneVolume(MainScene.inGameMusicToStop, sliderValue);
        SoundManager.setSoundVolume(sliderValue);
    }


}
