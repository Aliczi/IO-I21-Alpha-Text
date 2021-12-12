package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class Basic extends TextTransformer {
    @Override
    public String transform(String text){
        return new String(text);
    }
}
