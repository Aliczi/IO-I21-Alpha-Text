import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToLowerTest {

    @Test
    public void capitalized(){
        TextTransformer textTransformer = new ToLower(new TextHolder());
        assertEquals("wszystko z malych liter",textTransformer.transform("Wszystko Z Malych Liter"));
    }

    @Test
    public void allBig(){
        TextTransformer textTransformer = new ToLower(new TextHolder());
        assertEquals("wszystko z malych liter!",textTransformer.transform("WSZYSTKO Z MALYCH LITER!"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new ToLower(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}