package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete decorator class for changing abbreviation to full words
 * @author Michał Łopatka
 */
public class Abbreviation2Word extends Decorator {
    public Abbreviation2Word(TextTransformer size) {
        super(size);
    }

    private static final Logger logger = LoggerFactory.getLogger(Capitalize.class);

    public static final String[] abbreviation = {
            " ul.", " cd.", " cdn.", " CV", " dr", " itd.", " itp.", " str.", " mgr", " lek."
    };

    public static final String[] words = {
            " ulica", " ciąg dalszy", " ciąg dalszy nastąpi", " curriculum vitae",
            " doktor", " i tak dalej", " i tym podobne", " strona", " magister", " lekarz"
    };

    /**
     * Changes every abbreviation for full word.
     * @param text string to transform
     * @return String with every abbreviation changed to full word and passes it to the superclass transform method
     */
    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        String[] str_tab;
        for(int i=0;i<abbreviation.length;i++){
            if(text.endsWith(abbreviation[i]+".")){
                str_tab = text.split(abbreviation[i]+".");
                text = str_tab[0] + words[i]+".";
                i--;
            }
            else if(text.endsWith(abbreviation[i]+" ")){
                str_tab = text.split(abbreviation[i]+" ");
                text = str_tab[0] + words[i]+" ";
                i--;
            }
            else if(text.endsWith(abbreviation[i]+",")){
                str_tab = text.split(abbreviation[i]+",");
                text = str_tab[0] + words[i]+",";
                i--;
            }
            else if(text.endsWith(abbreviation[i]+";")){
                str_tab = text.split(abbreviation[i]+";");
                text = str_tab[0] + words[i]+";";
                i--;
            }
            else if(text.indexOf(abbreviation[i] + " ")!=-1){
                str_tab = text.split(abbreviation[i] + " ");
                text = str_tab[0] + words[i] + " " + str_tab[1];
                i--;
            }
            else if(text.indexOf(abbreviation[i] + ",")!=-1){
                str_tab = text.split(abbreviation[i] + ",");
                text = str_tab[0] + words[i] + "," + str_tab[1];
                i--;
            }
            else if(text.indexOf(abbreviation[i] + ";")!=-1){
                str_tab = text.split(abbreviation[i] + ";");
                text = str_tab[0] + words[i] + ";" + str_tab[1];
                i--;
            }
            else if(text.indexOf(abbreviation[i] + ".")!=-1){
                str_tab = text.split(abbreviation[i] + ".");
                text = str_tab[0] + words[i] + "." + str_tab[1];
                i--;
            }
            else if(text.endsWith(abbreviation[i])){
                str_tab = text.split(abbreviation[i]);
                text = str_tab[0] + words[i];
                i--;
            }
        }
        return super.transform(text);
    }
}