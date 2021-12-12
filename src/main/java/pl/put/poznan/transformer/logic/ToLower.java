package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Locale;


public class ToLower extends TextTransformer {
    @Override
    public String transform(String text){
        return text.toLowerCase();
    }
}
