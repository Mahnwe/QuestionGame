package view.customobject;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.creators.IconCreator;
import util.PathUtil;
import util.stringutiltranslate.UtilStringStorage;

public class ReturnButton  extends Button {

    public ReturnButton()
    {
       // Instantiate a custom return button
        IconCreator returnArrow = new IconCreator(PathUtil.BACK_ARROW);
        Image backArrow = returnArrow.createImage().getImage();

        this.setPrefHeight(80);
        this.setPrefWidth(80);

        Tooltip returnTooltip = new Tooltip(UtilStringStorage.returnButton);
        returnTooltip.setFont(Font.font("Futura", FontWeight.BOLD, 18));
        this.setTooltip(returnTooltip);

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(backArrow, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize)));
        CustomOption.setGlowEffectOnButton(this);
    }

}
