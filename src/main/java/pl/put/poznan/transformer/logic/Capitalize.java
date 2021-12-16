package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.rest.TextTransformerController;

/**
 * Concrete decorator class for capitalizing every first letter in a word for a given string
 * @author Paweł Perechuda
 */
public class Capitalize extends Decorator {
    public Capitalize(TextTransformer size) {
        super(size);
    }

    /**
     * Capitalizes every first letter in a word for a given string and passes it to the superclass.
     * @param text string to transform
     * @return String with capitalized every first letter of a word in a given string and passes it to the superclass transform method
     * @author Paweł Perechuda
     */
    @Override
    public String transform(String text){
        String[] str_tab = text.split("\\s");
        for (int i = 0; i < str_tab.length; ++i) {
            if (str_tab[i].length() > 0) {
                str_tab[i] = Character.toString(str_tab[i].charAt(0)).toUpperCase() + str_tab[i].substring(1);
            }
        }
        return super.transform(String.join(" ", str_tab));
    }
}
