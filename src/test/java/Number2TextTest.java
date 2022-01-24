import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Number2TextTest {

    @Test
    public void onlyNumber(){
        TextTransformer textTransformer = new Number2Text(new TextHolder());
        assertEquals("dwadzieścia dwa",textTransformer.transform("22"));
    }

    @Test
    public void sentenceWithNumber(){
        TextTransformer textTransformer = new Number2Text(new TextHolder());
        assertEquals("Zjadłem dzisiaj trzy bułki",textTransformer.transform("Zjadłem dzisiaj 3 bułki"));
    }

    @Test
    public void moreThanOneNumber(){
        TextTransformer textTransformer = new Number2Text(new TextHolder());
        assertEquals("Zjadłem dzisiaj trzy bułki i jeden chleb",textTransformer.transform("Zjadłem dzisiaj 3 bułki i 1 chleb"));
    }

    @Test
    public void bigNumber(){
        TextTransformer textTransformer = new Number2Text(new TextHolder());
        assertEquals("dziewięćset osiemdziesiąt siedem i sześćdziesiąt pięć setnych",textTransformer.transform("987.65"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Number2Text(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}