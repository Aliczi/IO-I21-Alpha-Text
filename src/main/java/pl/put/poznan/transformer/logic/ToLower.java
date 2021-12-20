package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Locale;


public class ToLower extends Decorator {

    private static final Logger logger = LoggerFactory.getLogger(ToLower.class);

    public ToLower(TextTransformer size) {
        super(size);
    }

    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        return super.transform(text.toLowerCase());
    }
}
