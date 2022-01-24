import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.CaesarCipher;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.Word2Abbreviation;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void cipher(){
        TextTransformer caesarCipher = new CaesarCipher(new TextHolder());
        assertEquals("L khfnlqj oryh Dufdqh!",caesarCipher.transform("I hecking love Arcane!"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new CaesarCipher(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }
}
