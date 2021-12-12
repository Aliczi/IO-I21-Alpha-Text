package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class Capitalize extends TextTransformer {
    public String transform(String text){
        return text.toUpperCase();
    }
}
