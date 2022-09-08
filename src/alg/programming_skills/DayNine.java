package alg.programming_skills;

import java.util.HashMap;
import java.util.Map;

public class DayNine {
    public static void main(String[] args) {

    }

    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                builder.append(Character.toLowerCase(s.charAt(i)));
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if(i+2<s.length() && s.charAt(i+2)=='#'){
                builder.append((char)('a'-1+Integer.parseInt(s.substring(i, i+2))));
                i += 3;
            } else {
                builder.append((char)('a'-1+Character.getNumericValue(s.charAt(i))));
                i++;
            }
        }
        return builder.toString();
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            int k = 0;
            while (k<words[i-1].length() && k < words[i].length()){
                if(map.get(words[i-1].charAt(k)) > map.get(words[i].charAt(k))) {
                    return false;
                } else if (map.get(words[i - 1].charAt(k)).equals(map.get(words[i].charAt(k)))) {
                    k++;
                } else {
                    break;
                }
                if(words[i].length()<words[i-1].length() && k==words[i].length() && words[i].charAt(k-1)==words[i-1].charAt(k-1)) return false;
            }

        }
        return true;
    }

}
