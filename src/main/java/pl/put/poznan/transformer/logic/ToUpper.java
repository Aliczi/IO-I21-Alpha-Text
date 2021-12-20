package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;


public class ToUpper extends Decorator {
    public ToUpper(TextTransformer size) {
        super(size);
    }

    private static final Logger logger = LoggerFactory.getLogger(ToUpper.class);

    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        return super.transform(text.toUpperCase());
    }
}
