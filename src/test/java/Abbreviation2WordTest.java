import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Abbreviation2Word;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Abbreviation2WordTest {

    @Test
    public void test1(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("Dzien dobry, z tej strony doktor Zielarz",abbreviation2Word.transform("Dzien dobry, z tej strony dr Zielarz"));
    }

    @Test
    public void test2(){
        TextTransformer abbreviation2Word = new Abbreviation2Word(new TextHolder());
        assertEquals("O! Pan doktor magister Wydra",abbreviation2Word.transform("O! Pan dr mgr Wydra"));
    }
}
