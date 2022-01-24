import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToUpperTest {

    @Test
    public void allSmall(){
        TextTransformer textTransformer = new ToUpper(new TextHolder());
        assertEquals("WSZYSTKO Z CAPSA!",textTransformer.transform("wszystko z capsa!"));
    }

    @Test
    public void mixed(){
        TextTransformer textTransformer = new ToUpper(new TextHolder());
        assertEquals("WSZYSTKO Z CAPSA",textTransformer.transform("wsZyStko z CaPsa"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new ToUpper(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}