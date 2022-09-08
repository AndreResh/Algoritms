package alg.programmingSkills_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFirst {
    public static void main(String[] args) {
        System.out.println(new DayFirst().strStr("hello","ll"));
    }
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }

    public int strStr(String haystack, String needle) {
        Pattern pattern = Pattern.compile(needle);
        if(needle.isEmpty()) return 0;
//        if(!haystack.matches(pattern.pattern())) return -1;
        Matcher matcher = pattern.matcher(haystack);
        System.out.println(matcher);
        while (matcher.find()){
            return haystack.indexOf(matcher.group());
        }
        return -1;
    }
}
