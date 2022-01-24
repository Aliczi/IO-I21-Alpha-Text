import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Convert2Latex;
import pl.put.poznan.transformer.logic.TextHolder;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Convert2LatexTest {

    @Test
    void singleCharacter() {
        String preparedStr = "#";
        TextHolder mockHolder = mock(TextHolder.class);
        TextTransformer textTransformer = new Convert2Latex(mockHolder);

        when(mockHolder.transform("\\" + preparedStr)).thenReturn("\\" + preparedStr);

        assertEquals("\\#", textTransformer.transform(preparedStr));
    }

    @Test
    void emptyString() {
        TextTransformer textTransformer = new Convert2Latex(new TextHolder());

        assertEquals("", textTransformer.transform(""));
    }

    @Test
    void multipleSpecialChar() {
        TextTransformer textTransformer = new Convert2Latex(new TextHolder());

        assertEquals("aa/\\\\\\#\\$ \\$ \\^\\_ ", textTransformer.transform("aa/\\#$ $ ^_ "));
    }
}
