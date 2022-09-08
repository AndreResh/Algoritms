package alg.programming_skills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EightDay {
    public static void main(String[] args) {

    }
    public String mergeAlternately(String word1, String word2) {
        int first = 0;
        int second = 0;
        StringBuilder builder = new StringBuilder();
        while (first < word1.length() && second< word2.length()){
            if(first==second){
                builder.append(word1.charAt(first++));
            } else {
                builder.append(word2.charAt(second++));
            }
        }
        while (first < word1.length()){
            builder.append(word1.charAt(first++));
        }
        while (second < word2.length()){
            builder.append(word2.charAt(second++));
        }
        return builder.toString();
    }

    public String interpret(String command) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < command.length()){
            switch (command.charAt(i)){
                case 'G':
                    builder.append(command.charAt(i++));
                    break;
                case '(':
                    if(command.charAt(i+1)==')'){
                        builder.append("o");
                        i+=2;
                    } else {
                        builder.append("al");
                        i+=4;
                    }
            }
        }
        return builder.toString();
    }

    public char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int i = 0;
        while (i<chars1.length){
            if(chars1[i]!=chars2[i]){
                return chars2[i];
            }
            i++;
        }
        return chars2[chars2.length-1];
    }
}
