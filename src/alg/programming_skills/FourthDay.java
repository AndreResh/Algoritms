package alg.programming_skills;



import alg.domains.Node;

import java.util.*;

public class FourthDay {
    public static void main(String[] args) {
    }

    public int arraySign(int[] nums) {
        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                r *= -1;
            }
        }
        return r;
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int prog = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != prog) return false;
        }
        return true;
    }

    Set<Integer> set;

    public boolean isHappy(int n) {
        set = new HashSet<>();
        return happyOrNot(n);
    }

    public boolean happyOrNot(int n) {
        if (set.contains(n)) return false;
        if (n == 1) return true;
        set.add(n);
        String s = String.valueOf(n);
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number += Math.pow(Character.getNumericValue(s.charAt(i)), 2);
        }

        return happyOrNot(number);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (chars1[i] != chars2[i]) {

                int j = i + 1;
                while (j < chars2.length && (chars2[j] != chars1[i] || chars1[j] != chars2[i])) {
                    j++;
                }
                if (j == chars2.length) return false;
                char a = chars2[i];
                chars2[i] = chars2[j];
                chars2[j] = a;
                break;
            }
        }
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }



}
