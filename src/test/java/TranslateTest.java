import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.stringutiltranslate.UtilStringStorage;
import util.stringutiltranslate.UtilTranslateString;

import static org.assertj.core.api.Assertions.assertThat;

class TranslateTest
{
    private UtilTranslateString utilTranslateString;

    @BeforeEach
    void createTranslateElement()
    {
        utilTranslateString = new UtilTranslateString();
    }

    @Test
    void testFrTranslate()
    {
        utilTranslateString.loadFrTradFile();
        utilTranslateString.translateFrString();

        assertThat(UtilStringStorage.gameTitle).isEqualTo("Turbo Jeu des Questions");
    }

    @Test
    void testEngTranslate()
    {
        utilTranslateString.loadEngTradFile();
        utilTranslateString.translateEngString();

        assertThat(UtilStringStorage.gameTitle).isEqualTo("Turbo Questions Game");
    }
}
