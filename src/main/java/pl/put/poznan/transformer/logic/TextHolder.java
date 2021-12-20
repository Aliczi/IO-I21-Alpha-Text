package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete component for holding transformed text
 * @author Paweł Perechuda
 */
public class TextHolder extends TextTransformer {

    private static final Logger logger = LoggerFactory.getLogger(TextHolder.class);

    /**
     * Just returns a string
     * @param text string to transform
     * @return string to transform
     */
    @Override
    public String transform(String text) {
        logger.debug("Used transform method on: " + text);
        return text;
    }
}
