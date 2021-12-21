package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Locale;

/**
 * Concrete decorator class for lowering every letter in a given string
 * @author Michał Łopatka
 */
public class ToLower extends Decorator {

    private static final Logger logger = LoggerFactory.getLogger(ToLower.class);

    public ToLower(TextTransformer size) {
        super(size);
    }

    /**
     * Lowers every letter in a given string and passes it to the superclass.
     * @param text string to transform
     * @return String with lowered every letter in a given string and passes it to the superclass transform method
     */
    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        return super.transform(text.toLowerCase());
    }
}
