package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates extends Decorator {
    public RemoveDuplicates(TextTransformer size) {
        super(size);
    }

    @Override
    public String transform(String text) {
        ArrayList<String> str_arr = new ArrayList<>(Arrays.asList(text.split(" ")));
        for (int i = 1; i < str_arr.size(); ++i) {
            if (str_arr.get(i - 1).equals(str_arr.get(i))) {
                str_arr.remove(i);
                --i;
            }
        }
        return super.transform(String.join(" ", str_arr));
    }
}
