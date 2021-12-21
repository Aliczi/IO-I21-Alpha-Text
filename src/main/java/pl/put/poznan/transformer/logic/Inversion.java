package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.Decorator;
import pl.put.poznan.transformer.rest.TextTransformerController;

import java.util.ArrayList;

/**
 * Concrete decorator class for inverting a given string with keeping places of capitalization
 * @author Michał Łopatka
 */
public class Inversion extends Decorator  {
    public Inversion(TextTransformer size){
        super(size);
    }

    private static final Logger logger = LoggerFactory.getLogger(Inversion.class);

    /**
     * Inverts a given string with keeping places of capitalization and passes it to the superclass.
     * @param text string to transform
     * @return Inverted string with places of capitalization kept and passes it to the superclass transform method
     */
    @Override
    public String transform(String text) {
        logger.debug("Used transform method on: " + text);
        ArrayList<Boolean> tab = new ArrayList<Boolean>();
        for(int i=0; i<text.length(); i++)
        {
            if (text.charAt(i) == text.toUpperCase().charAt(i)) {
                tab.add(true);
            }
            else{
                tab.add(false);
            }
        }
        StringBuilder res = new StringBuilder("");

        for(int i=0;i<text.length();i++)
        {
            if(tab.get(i) == true){
                text=text.toUpperCase();
            }
            else{
                text=text.toLowerCase();
            }
            res.append(text.charAt(text.length() - 1 - i));
        }
        return super.transform(res.toString());
    }
}
