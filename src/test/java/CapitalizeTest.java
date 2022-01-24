import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalizeTest {

    @Test
    public void allSmall(){
        TextTransformer textTransformer = new Capitalize(new TextHolder());
        assertEquals("Wszystko Z Duzych Liter",textTransformer.transform("wszystko z duzych liter"));
    }

    @Test
    public void mixed(){
        TextTransformer textTransformer = new Capitalize(new TextHolder());
        assertEquals("Wszystko Z Duzych Liter",textTransformer.transform("Wszystko z duzych Liter"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Capitalize(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}