import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Abbreviation2Word;
import pl.put.poznan.transformer.logic.RemoveDuplicates;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Abbreviation2WordTest {

    @Test
    public void oneAbbreviation(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("Dzien dobry, z tej strony doktor Zielarz",abbreviation2Word.transform("Dzien dobry, z tej strony dr Zielarz"));
    }

    @Test
    public void moreThanOne(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("O! Pan doktor magister.",abbreviation2Word.transform("O! Pan dr mgr."));
    }

    @Test
    public void moreThanOneSame(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("O! Pan doktor doktor dzień dobry.",abbreviation2Word.transform("O! Pan dr dr dzień dobry."));
    }

    @Test
    public void abbreviaitonInWord(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("Wydra, drzewo",abbreviation2Word.transform("Wydra, drzewo"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Abbreviation2Word(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }
}
