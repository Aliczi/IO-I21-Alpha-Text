import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionTest {

    @Test
    public void smallTextInversion(){
        TextTransformer textTransformer = new Inversion(new TextHolder());
        assertEquals("pisze od tylu",textTransformer.transform("ulyt do ezsip"));
    }

    @Test
    public void bigTextInversion(){
        TextTransformer textTransformer = new Inversion(new TextHolder());
        assertEquals("OD TYLU PISZE",textTransformer.transform("EZSIP ULYT DO"));
    }

    @Test
    public void mixed1(){
        TextTransformer textTransformer = new Inversion(new TextHolder());
        assertEquals("DLUGIEslowo",textTransformer.transform("OWOLSEiguld"));
    }


    @Test
    public void mixed2(){
        TextTransformer textTransformer = new Inversion(new TextHolder());
        System.out.println();
        assertEquals("JAKIES FAjne zdanieee!!!",textTransformer.transform("!!!EEEINADZ enjaf seikaj"));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Inversion(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

}