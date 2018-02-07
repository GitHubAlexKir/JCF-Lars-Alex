package unit;

import org.junit.Before;
import org.junit.Test;
import woordenapplicatie.gui.WordClass;
import org.junit.Assert;

public class TestLessonOne {

    WordClass wordClass;

    private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er een van bordpapier\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we het in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    @Before
    public void setup()
    {
        this.wordClass = new WordClass();
    }

    @Test
    public void testAantalAction()
    {
        Assert.assertEquals(
                wordClass.aantalAction(this.DEFAULT_TEXT),
                "Totaal aantal woorden: 68\n" + "Aantal verschillende woorden: : 25"
        );
    }

    @Test
    public void testSorteerAction()
    {
        Assert.assertEquals(
                wordClass.sortAction(this.DEFAULT_TEXT),
                "zetten\n" + "we\n" + "vier\n" + "van\n" + "twee\n" + "past\n" + "papier\n" + "niet\n" + "meer\n" + "maak\n" + "je\n" + "in\n" + "hoedje\n" + "het\n" + "heb\n" + "glazenkas\n" + "geen\n" + "er\n" + "en\n" + "een\n" + "drie\n" + "de\n" + "dan\n" + "bordpapier\n" + "als\n"
        );
    }

    @Test
    public void testFrequentieAction()
    {
        Assert.assertEquals(
                wordClass.frequentieAction(this.DEFAULT_TEXT),
                "glazenkas=1\n" + "de=1\n" + "heb=1\n" + "maak=1\n" + "we=1\n" + "niet=1\n" + "zetten=1\n" + "in=1\n" + "past=1\n" + "en=1\n" + "als=1\n" + "er=1\n" + "meer=1\n" + "geen=1\n" + "je=1\n" + "bordpapier=1\n" + "dan=2\n" + "het=2\n" + "papier=4\n" + "drie=6\n" + "twee=6\n" + "vier=6\n" + "een=7\n" + "van=9\n" + "hoedje=10\n"
        );
    }

    @Test
    public void testConcordatieAction()
    {
        Assert.assertEquals(
                wordClass.concordatieAction(this.DEFAULT_TEXT),
                "de [17]\n" + "heb [6]\n" + "drie [1, 3, 8, 11, 13, 18]\n" + "maak [7]\n" + "dan [6, 16]\n" + "het [16, 17]\n" + "vier [1, 3, 8, 11, 13, 18]\n" + "niet [16]\n" + "zetten [17]\n" + "van [2, 4, 7, 9, 12, 14, 19]\n" + "in [17]\n" + "past [16]\n" + "en [1, 3, 6, 7, 8, 11, 13, 16, 17, 18]\n" + "als [16]\n" + "er [1, 3, 4, 6, 7, 8, 9, 11, 13, 14, 18, 19]\n" + "geen [6]\n" + "je [2, 4, 6, 9, 12, 14, 16, 19]\n" + "glazenkas [17]\n" + "we [1, 3, 8, 11, 13, 17, 18]\n" + "een [1, 3, 6, 7, 8, 11, 13, 18]\n" + "twee [1, 3, 8, 11, 13, 18]\n" + "hoedje [2, 4, 6, 9, 12, 14, 16, 19]\n" + "meer [6]\n" + "papier [4, 7, 9, 14, 19]\n" + "bordpapier [7]\n"
        );
    }
}