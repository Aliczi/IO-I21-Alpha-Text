package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class ToUpper extends Decorator {
    public ToUpper(TextTransformer size) {
        super(size);
    }

    @Override
    public String transform(String text){
        /*return text.toUpperCase();*/
        return super.transform(text.toUpperCase());
    }
}
