package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;
import java.util.Collections;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String[] get(@PathVariable String text,
                        @RequestParam(value="transforms", defaultValue="lower,capitalize") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = matrioshka(transforms);
        return new String[]{transformer.transform(text)};
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String[] post(@PathVariable String text,
                         @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = matrioshka(transforms);
        return new String[]{transformer.transform(text)};
    }

    /**
     * Creates proper TextTransformer for a given list of transforms
     * @param transforms array of transformations
     * @return TextTransformer object to be used on a String
     * @throws RuntimeException
     */
    private TextTransformer matrioshka(String[] transforms) {
        TextTransformer res = new TextHolder();
        Collections.reverse(Arrays.asList(transforms));

        for (String elem : transforms) {
            switch(elem) {
                case "lower":
                    res = new ToLower(res);
                    break;
                case "upper":
                    res = new ToUpper(res);
                    break;
                case "inversion":
                    res = new Inversion(res);
                    break;
                case "capitalize":
                    res = new Capitalize(res);
                    break;
                case "removeDuplicates":
                    res = new RemoveDuplicates(res);
                    break;
                case "Numbers2Text":
                    res = new Number2Text(res);
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return res;
    }

}


