package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Concrete decorator class for changing full words to abbreviation
 * @author Michał Łopatka
 */
public class Word2Abbreviation extends Decorator {
    public Word2Abbreviation(TextTransformer size) {
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
     * Changes full words for abbreviation.
     * @param text string to transform
     * @return String with full words changed to abbreviation and passes it to the superclass transform method
     */
    @Override
    public String transform(String text){
        logger.debug("Used transform method on: " + text);
        String[] str_tab;
        for(int i=0;i<words.length;i++){
            if(text.endsWith(words[i]+".")){
                str_tab = text.split(words[i]+".");
                text = str_tab[0] + abbreviation[i]+".";
                i--;
            }
            else if(text.endsWith(words[i]+" ")){
                str_tab = text.split(words[i]+" ");
                text = str_tab[0] + abbreviation[i]+" ";
                i--;
            }
            else if(text.endsWith(words[i]+",")){
                str_tab = text.split(words[i]+",");
                text = str_tab[0] + abbreviation[i]+",";
                i--;
            }
            else if(text.endsWith(words[i]+";")){
                str_tab = text.split(words[i]+";");
                text = str_tab[0] + abbreviation[i]+";";
                i--;
            }
            else if(text.indexOf(words[i] + " ")!=-1){
                str_tab = text.split(words[i] + " ");
                text = str_tab[0] + abbreviation[i] + " " + str_tab[1];
                i--;
            }
            else if(text.indexOf(words[i] + ",")!=-1){
                str_tab = text.split(words[i] + ",");
                text = str_tab[0] + abbreviation[i] + "," + str_tab[1];
                i--;
            }
            else if(text.indexOf(words[i] + ";")!=-1){
                str_tab = text.split(words[i] + ";");
                text = str_tab[0] + abbreviation[i] + ";" + str_tab[1];
                i--;
            }
            else if(text.indexOf(words[i] + ".")!=-1){
                str_tab = text.split(words[i] + ".");
                text = str_tab[0] + abbreviation[i] + "." + str_tab[1];
                i--;
            }
            else if(text.endsWith(words[i])){
                str_tab = text.split(words[i]);
                text = str_tab[0] + abbreviation[i];
                i--;
            }
        }
        return super.transform(text);
    }
}