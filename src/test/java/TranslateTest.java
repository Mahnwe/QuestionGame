import model.UtilStringStorage;
import model.UtilTranslateString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateTest
{
    @Test
    public void testTranslate()
    {
        UtilTranslateString utilFrTranslateString = new UtilTranslateString();
        utilFrTranslateString.loadFrTradFile();
        utilFrTranslateString.translateFrString();
        assertEquals("Turbo Jeu des Questions", UtilStringStorage.gameTitle);

        UtilTranslateString utilEngTranslateString = new UtilTranslateString();
        utilEngTranslateString.loadEngTradFile();
        utilEngTranslateString.translateEngString();
        assertEquals("Turbo Questions Game", UtilStringStorage.gameTitle);
    }
}
