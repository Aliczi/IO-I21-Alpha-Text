package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.rest.TextTransformerController;


public class Capitalize extends TextTransformer {
    @Override
    public String transform(String text){
        String[] str_tab = text.split("\\s");
        for (int i = 0; i < str_tab.length; ++i) {
            if (str_tab[i].length() > 0) {
                str_tab[i] = Character.toString(str_tab[i].charAt(0)).toUpperCase() + str_tab[i].substring(1);
            }
        }
        return String.join(" ", str_tab);
    }
}
