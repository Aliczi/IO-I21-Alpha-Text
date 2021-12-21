package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;

/**
 * Concrete decorator class for capitalizing every letter in a given string
 * @author Michał Łopatka
 */
public class ToUpper extends Decorator {
    public ToUpper(TextTransformer size) {
        super(size);
    }

    private static final Logger logger = LoggerFactory.getLogger(ToUpper.class);


    /**
     * Capitalizes every letter in a given string and passes it to the superclass.
     * @param text string to transform
     * @return String with capitalized every letter in a given string and passes it to the superclass transform method
     */
    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        return super.transform(text.toUpperCase());
    }
}
