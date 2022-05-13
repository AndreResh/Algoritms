package alg.dataStructure;

import java.util.*;

public class SixDay {
    public static void main(String[] args) {
        System.out.println(new SixDay().isAnagram("rat", "car"));
    }

    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> count = new HashMap<>();
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//        for (int i = 0; i < n; i++) {
//            if (count.get(s.charAt(i)) == 1)
//                return i;
//        }
//        return -1;

        Set<Character> oldSet = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        char z;
        for (int i = 0; i < s.length(); i++) {
            z = s.charAt(i);
            if(!oldSet.contains(z)){
                if(map.containsKey(z)){
                    oldSet.add(z);
                    map.remove(z);
                } else {
                    map.put(z, i);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            return entry.getValue();
        }
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = mapFromString(ransomNote);
        char z;
        for (int i = 0; i < magazine.length(); i++) {
            z = magazine.charAt(i);
            if (map.containsKey(z)) {
                int a = map.get(z);
                if (a == 1) {
                    map.remove(z);
                } else {
                    map.put(z, a - 1);
                }
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram(String s, String t) {
//        Map<Character,Integer> map1 = mapFromString(s);
//        Map<Character,Integer> map2 = mapFromString(t);
//        return map1.equals(map2);


//        if (s.length() != t.length()) return false;
//        char[] chars1 = s.toCharArray();
//        char[] chars2 = t.toCharArray();
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//        for (int i = 0; i < chars1.length; i++) {
//            if (chars1[i] != chars2[i]) {
//                return false;
//            }
//        }
//        return true;

        if(s.length() != t.length()) {
            return false;
        }
        int[] freqCount = new int[26];
        for(char letter: s.toCharArray()) {
            freqCount[letter-'a']++;
        }
        System.out.println(Arrays.toString(freqCount));
        for(char letter: t.toCharArray()) {
            freqCount[letter-'a']--;
        }
        System.out.println(Arrays.toString(freqCount));
        for(int i=0;i<26;i++) {
            if(freqCount[i] != 0) {
                return false;
            }
        }
        return true;

    }

    private Map<Character, Integer> mapFromString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char z;
        for (int i = 0; i < s.length(); i++) {
            z = s.charAt(i);
            map.put(z, map.getOrDefault(z, 0) + 1);
        }
        return map;
    }
}
