package alg.dataStructure2;

import java.util.*;
import java.util.regex.Pattern;

public class FiveDay {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*SA.*", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher("SA").matches());
    }

}
