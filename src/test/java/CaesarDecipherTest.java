import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.CaesarCipher;
import pl.put.poznan.transformer.logic.CaesarDecipher;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarDecipherTest {

    @Test
    public void decipher(){
        TextTransformer caesarDecipher = new CaesarDecipher(new TextHolder());
        assertEquals("I hecking love Arcane!",caesarDecipher.transform("L khfnlqj oryh Dufdqh!"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new CaesarCipher(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}