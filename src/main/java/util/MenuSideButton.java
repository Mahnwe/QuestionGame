package util;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.MenuScene;

public class MenuSideButton extends Button
{
    public MenuSideButton(String buttonText, String tooltipText, int translateX, int translateY)
    {
        this.setText(buttonText);
        Tooltip tooltip = new Tooltip(tooltipText);
        this.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 14));
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
        this.setTooltip(tooltip);
        CustomOption.setGlowEffectOnButton(this);
    }
}
