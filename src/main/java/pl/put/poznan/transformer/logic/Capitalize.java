package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class Capitalize extends TextTransformer {
    @Override
    public String transform(String text){
        String[] str_tab = text.split("\\s");
        for (int i = 0; i < str_tab.length; ++i) {
            str_tab[i] = Character.toString(str_tab[i].charAt(0)).toUpperCase() + str_tab[i].substring(1);
        }
        return String.join(" ", str_tab);
    }
}
