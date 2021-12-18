package pl.put.poznan.transformer.logic;


import java.util.Arrays;
import java.util.List;

public class Number2Text extends Decorator {
    public Number2Text(TextTransformer size) {
        super(size);
    }


    public static final String[] units = {
            "", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem",
            "osiem", "dziewięć", "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście",
            "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"
    };
    public static final String[] fracUnits = {
            "", "jeden", "dwie", "trzy", "cztery", "pięć", "sześć", "siedem",
            "osiem", "dziewięć", "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście",
            "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"
    };


    public static final String[] tens = {
            "",        // 0
            "",        // 1
            "dwadzieścia",  // 2
            "trzydzieści",  // 3
            "czterdzieści",   // 4
            "pięćdziesiąt",   // 5
            "sześćdziesiąt",   // 6
            "siedemdziesiąt", // 7
            "osiemdziesiąt",  // 8
            "dziewięćdziesiąt"   // 9
    };
    public static final String[] hundreds = {
            "",        // 0
            "sto",        // 1
            "dwieście",  // 2
            "trzysta",  // 3
            "czterysta",   // 4
            "pięćset",   // 5
            "sześćset",   // 6
            "siedemset", // 7
            "osiemset",  // 8
            "dziewięćset"   // 9
    };

    public static boolean isDouble(String str) {
        try {
            double v = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    public static boolean isInt(String str) {
        try {
            double v = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    public static String convert(final int n, final String[] units) {
        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return hundreds[n / 100]  + ((n % 100 != 0) ? " " : "") + convert(n % 100,units);
        }

        if (n == 1000) {
            return "tysiąc";
        }

        return Integer.toString(n);
    }


    public String transform(String text) {
        StringBuilder res = new StringBuilder("");
        List<String> words = Arrays.asList(text.trim().split(" "));

        for(int i=0; i < words.size(); i++ ){

            if ( isInt(words.get(i)) ){
                int b = Integer.valueOf(words.get(i));
                if (b<=1000 && b>0) res.append(convert(b,units)); else res.append(words.get(i));


            }
            else if(isDouble(words.get(i))){
                double d = Double.parseDouble(words.get(i));
                String s=words.get(i);
                if (s.charAt(s.length() - 1)=='.') s=s+"0";
                List<String> frac =  Arrays.asList(s.split("\\."));
                int a = Integer.valueOf(frac.get(0));
                int b = Integer.valueOf(String.format("%-3s",frac.get(1)).replace(' ','0'));

                if (d<=1000 && d>0) {
                    res.append((convert(a,units)));
                    while (b > 1000) b /= 10;

                    if(b==0) res.append(".");
                    else if(b%100==0){
                        b/=100;
                        switch(b){
                            case 1:
                                res.append(("jedna dziesiąta"));
                                break;
                            case 2:
                                res.append(" i "+convert(b,fracUnits)+ " dziesiąte");
                                break;
                            case 3:
                                res.append(" i "+convert(b,fracUnits)+ " dziesiąte");
                                break;
                            case 4:
                                res.append(" i "+convert(b,fracUnits)+ " dziesiąte");
                                break;
                            default:

                                res.append(" i "+convert(b,fracUnits)+ " dziesiątych");
                        }}
                    else if(b%10==0){
                        String setki="";
                        if(b==10) res.append("jedna setna");
                        else{
                            b/=10;
                            if((b%10==2 || b%10==3 || b%10==4)&& b!=12 && b!=13 && b!=14) setki =  " setne";
                            else setki = " setnych";
                            res.append(" i "+convert(b, fracUnits)+ setki);
                        }
                    }
                    else{
                        String tys="";
                        if(b==1) res.append("jedna tysięczna");
                        else{
                            if((b%10==2 || b%10==3 || b%10==4) && b%100!=12 && b%100!=13 && b%100!=14) tys =  " tysięczne";
                            else tys=" tysięcznych";
                            res.append(" i "+convert(b,fracUnits)+tys);
                        }
                    }

                }else res.append(s);

            }
            else{
                res.append(words.get(i));
            }
            if(i!=words.size()-1) res.append(" ");
        }

        return super.transform(res.toString());
    }
}
