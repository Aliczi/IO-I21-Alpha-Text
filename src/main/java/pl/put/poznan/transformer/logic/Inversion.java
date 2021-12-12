package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.Decorator;

import java.util.ArrayList;


public class Inversion extends Decorator  {
    public Inversion(TextTransformer size){
        super(size);
    }

    public String transform(String text) {
        ArrayList<Boolean> tab = new ArrayList<Boolean>();
        for(int i=0; i<text.length(); i++)
        {
            if (text.charAt(i) == text.toUpperCase().charAt(i)) {
                tab.add(true);
            }
            else{
                tab.add(false);
            }
        }
        StringBuilder res = new StringBuilder("");

        for(int i=0;i<text.length();i++)
        {
            if(tab.get(i) == true){
                text=text.toUpperCase();
            }
            else{
                text=text.toLowerCase();
            }
            res.append(text.charAt(text.length() - 1 - i));
        }
        return super.transform(res.toString());
    }
}
