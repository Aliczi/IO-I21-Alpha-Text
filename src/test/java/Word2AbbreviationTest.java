import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Word2Abbreviation;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Word2AbbreviationTest {

    @Test
    public void test1(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("Dzien dobry, z tej strony dr Zielarz",word2Abbreviation.transform("Dzien dobry, z tej strony doktor Zielarz"));
    }

    @Test
    public void test2(){
        TextTransformer word2Abbreviation = new Word2Abbreviation(new TextHolder());
        assertEquals("O! Pan dr mgr Wydra",word2Abbreviation.transform("O! Pan doktor magister Wydra"));
    }
}
