package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Concrete decorator class for removing duplicates in a given string.
 * @author Paweł Perechuda
 */
public class RemoveDuplicates extends Decorator {
    public RemoveDuplicates(TextTransformer size) {
        super(size);
    }

    /**
     * Removes duplicates from a given string and passes to the superclass.
     * @param text string to transform
     * @return string with removed duplicated neighbouring words as an invocation of superclass transform method
     */
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
