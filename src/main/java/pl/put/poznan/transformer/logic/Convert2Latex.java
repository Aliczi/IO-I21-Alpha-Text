package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Concrete decorator for conversion of special characters in latex to their printable counterparts
 * @author Paweł Perechuda
 */
public class Convert2Latex extends Decorator {
    public Convert2Latex(TextTransformer size) { super(size); }

    private static final Logger logger = LoggerFactory.getLogger(Convert2Latex.class);

    Map<String, String> map = Map.of(
            "\\", "\\\\", // must be the first elem
            "~", "\\~",
            "$", "\\$",
            "_", "\\_",
            "^", "\\^",
            "}", "\\}",
            "{", "\\{",
            "&", "\\&",
            "#", "\\#"
    );

    /**
     * Swaps LaTeX special characters to their printable counterparts in LaTeX
     * @param text string to transform
     * @return string with all special LaTeX characters changed to their printable counterparts
     */
    @Override
    public String transform(String text) {
        logger.debug("Used transform method on: " + text);
        for (Map.Entry<String, String> elem : map.entrySet()) {
            text = text.replace(elem.getKey(), elem.getValue());
        }
        return super.transform(text);
    }

}
