package view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import util.IconCreator;
import util.PathUtil;
import util.UtilStringStorage;

public class ReturnButton  extends Button {

    public ReturnButton()
    {
       // Instantiate a custom return button
        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        this.setPrefHeight(70);
        this.setPrefWidth(70);
        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        this.setTooltip(returnTooltip);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
    }

}
