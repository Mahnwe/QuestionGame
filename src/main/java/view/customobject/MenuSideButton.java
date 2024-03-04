package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.scene.MenuScene;

public class MenuSideButton extends Button
{
    public MenuSideButton(String buttonText, String tooltipText, int translateX)
    {
        this.setText(buttonText);
        Tooltip tooltip = new Tooltip(tooltipText);
        this.setFont(Font.font(MenuScene.POLICE_LABEL, FontWeight.BOLD, 22));
        this.setTooltip(tooltip);
        this.setBorder(CustomOption.createCustomBorder(3.0, 2.0, Color.BLACK));
        this.setTranslateX(translateX);
        CustomOption.setGlowEffectOnButton(this);
    }
}
