package view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.IconCreator;
import util.PathUtil;

public class InfoButton extends Button {

    public InfoButton(String buttonTooltip)
    {
        Tooltip tooltip = new Tooltip(buttonTooltip);
        tooltip.setFont(Font.font("Futura", FontWeight.BOLD, 18));
        this.setTooltip(tooltip);
        this.setTranslateX(100);

        IconCreator iconCreator = new IconCreator(PathUtil.INFO_ICON);
        ImageView imageView = iconCreator.createImage();
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        this.setGraphic(imageView);
    }
}
