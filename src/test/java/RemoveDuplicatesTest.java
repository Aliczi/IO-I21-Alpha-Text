import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.RemoveDuplicates;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesTest {

    @Test
    void emptyString() {
        TextTransformer textTransformer = new RemoveDuplicates(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

    @Test
    void oneDuplicate() {
        TextTransformer textTransformer = new RemoveDuplicates(new TextHolder());

        assertEquals("ha", textTransformer.transform("ha ha"));
    }

    @Test
    void moreThanTwoInARow() {
        TextTransformer textTransformer = new RemoveDuplicates(new TextHolder());

        assertEquals("ha", textTransformer.transform("ha ha ha"));
        assertEquals("ha a", textTransformer.transform("ha ha ha ha a"));
    }

    @Test
    void exampleString() {
        TextTransformer textTransformer = new RemoveDuplicates(new TextHolder());

        assertEquals("Nie dotarłem do tego punktu. A a hmm, hmm", textTransformer.transform("Nie dotarłem do do tego punktu. A a hmm, hmm"));
    }
}
