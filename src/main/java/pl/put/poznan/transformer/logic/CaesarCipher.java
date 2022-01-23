package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete decorator class for encrypting text with Ceasar cipher.
 * @author Michał Łopatka
 */
public class CaesarCipher extends Decorator {
    public CaesarCipher(TextTransformer size) {
        super(size);
    }

    private static final Logger logger = LoggerFactory.getLogger(Capitalize.class);

    /**
     * Encrypts text with Ceasar cipher and passes it to the superclass.
     * @param text string to transform
     * @return String encrypted with Ceasar cipher and passes it to the superclass transform method
     */
    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        String res = "";
        for(int i=0 ; i<text.length();i++){
            if(text.charAt(i) <= 90 && text.charAt(i) >= 65){
                res = res + (char)(65 + ((text.charAt(i)-65+3)%26));
            }
            else if(text.charAt(i) <= 122 && text.charAt(i) >= 97){
                res = res + (char)(97 + ((text.charAt(i)-97+3)%26));
            }
            else{
                res = res + text.charAt(i);
            }
        }
        return super.transform(res);
    }
}
