package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class ToUpper extends TextTransformer {
    @Override
    public String transform(String text){
        return text.toUpperCase();
    }
}
