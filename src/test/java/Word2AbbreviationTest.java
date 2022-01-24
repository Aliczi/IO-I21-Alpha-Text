import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Word2AbbreviationTest {

    @Test
    public void oneAbbreviation(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("Dzien dobry, z tej strony dr Zielarz",word2Abbreviation.transform("Dzien dobry, z tej strony doktor Zielarz"));
    }

    @Test
    public void moreThanOne(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("O! Pan dr mgr.",word2Abbreviation.transform("O! Pan doktor magister."));
    }

    @Test
    public void moreThanOneSame(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("O! Pan dr dr dzień dobry.",word2Abbreviation.transform("O! Pan doktor doktor dzień dobry."));
    }

    @Test
    public void abbreviaitonInWord(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("Wydra, drzewo",word2Abbreviation.transform("Wydra, drzewo"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Word2Abbreviation(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }
}
