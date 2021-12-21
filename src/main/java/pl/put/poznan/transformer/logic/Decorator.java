package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.TextTransformer;


/**
 * Base for creating all decorator classes
 */
public abstract class Decorator extends TextTransformer {
    private TextTransformer textTransformer;

    public Decorator(TextTransformer size){
        textTransformer = size;
    };
    @Override
    public String transform(String text){
        return textTransformer.transform(text);
    }

}
