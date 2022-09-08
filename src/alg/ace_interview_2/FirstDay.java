package alg.ace_interview_2;

import java.util.HashSet;
import java.util.Set;

public class FirstDay {
    public static void main(String[] args) {

    }
    Set<Integer> unhappy = new HashSet<>();
    public boolean isHappy(int n) {
        if(unhappy.contains(n)) return false;
        int res = 0;
        String number= String.valueOf(n);
        for (int i = 0; i < number.length(); i++) {
            res += Math.pow(Character.getNumericValue(number.charAt(i)), 2);
        }
        if(res==1) return true;
        return isHappy(res);
    }
}
