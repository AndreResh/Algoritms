package alg.algorithm;

import java.util.*;

public class SixDay {
        public static void main(String[] args) {
//        System.out.println(new SixDay().checkInclusion("ab","eidbaoo"));
            System.out.println(new SixDay().lengthOfLongestSubstring("abba"));
    }

//    3. Longest Substring Without Repeating C
    public int lengthOfLongestSubstring(String s) {
//        Integer[] chars = new Integer[128];
//        int left = 0;
//        int right = 0;
//        int res = 0;
//        while (right < s.length()) {
//            char r = s.charAt(right);
//            Integer index = chars[r];
//            if (index != null && index >= left && index < right) {
//                left = index + 1;
//            }
//            res = Math.max(res, right - left + 1);
//            chars[r] = right;
//            right++;
//        }
//        return res;

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)), j);
            }
            map.put(s.charAt(i), i+1);
            max = Math.max(max, map.get(s.charAt(i))-j);
        }
        return max;
    }

//    567. Permutation in String
    public boolean checkInclusion(String s1, String s2) {
//       int[] mainString = new int[26];
//       for (char q: s1.toCharArray()){
//           mainString[q-'a']++;
//       }
//        for (int i = 0; i < s2.length()-s1.length(); i++) {
//            if(isContainsString(mainString, s2.substring(i, i+s1.length()))){
//                return true;
//            }
//        }
//        return false;

        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }

    private boolean isContainsString(int[] mainString, String substring) {
        int[] copy = Arrays.copyOf(mainString, mainString.length);
        System.out.println(substring);
        for (char q: substring.toCharArray()){
            copy[q-'a']--;
        }
        for (int i = 0; i < copy.length; i++) {
            if(copy[i]!=0){
                return false;
            }

        }
        return true;
    }
}
