import org.junit.jupiter.api.Test;
import util.UtilStringStorage;
import util.UtilTranslateString;

import static org.assertj.core.api.Assertions.assertThat;

class TranslateTest
{
    @Test
    void testTranslate()
    {
        UtilTranslateString utilFrTranslateString = new UtilTranslateString();
        utilFrTranslateString.loadFrTradFile();
        utilFrTranslateString.translateFrString();

        assertThat(UtilStringStorage.gameTitle).isEqualTo("Turbo Jeu des Questions");


        UtilTranslateString utilEngTranslateString = new UtilTranslateString();
        utilEngTranslateString.loadEngTradFile();
        utilEngTranslateString.translateEngString();

        assertThat(UtilStringStorage.gameTitle).isEqualTo("Turbo Questions Game");
    }
}
