package pl.put.poznan.transformer.logic;
import pl.put.poznan.transformer.logic.TextTransformer;


public class Capitalize extends TextTransformer {
    @Override
    public String transform(String text){
        String words[]=text.split("\\s");
        String newString ="";
        for(String w: words){
            String first = w.substring(0,1);      //First Letter
            String rest = w.substring(1);         //Rest of the letters
            newString+=first.toUpperCase()+ rest+ " ";
        }
        return newString.trim();
    }
}
