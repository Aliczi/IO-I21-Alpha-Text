package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Locale;


public class ToLower extends Decorator {
    public ToLower(TextTransformer size) {
        super(size);
    }

    @Override
    public String transform(String text){
        /*return text.toLowerCase();*/
        return super.transform(text.toLowerCase());
    }
}
