import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.CaesarCipher;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void test1(){
        TextTransformer caesarCipher = new CaesarCipher(new TextHolder());
        assertEquals("L khfnlqj oryh Dufdqh!",caesarCipher.transform("I hecking love Arcane!"));
    }

}
