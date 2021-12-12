package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.TextTransformer;

public abstract class Decorator extends TextTransformer {
    TextTransformer textTransformer;

    public Decorator(){};
    public abstract String transform(String text);

}
