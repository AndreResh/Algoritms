package alg.sliding_window;

import java.util.*;

public class FistDaySlidingWindow {
    public static void main(String[] args) {
        System.out.println(new FistDaySlidingWindow().dNums(new ArrayList<>(List.of(1, 2, 1, 3, 4, 3)), 3));
    }
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new ArrayList<>();
//        int[] main = new int[26];
//        for (int i = 0; i < p.length(); i++) {
//            main[p.charAt(i)-'a']++;
//        }
//        int[] sArr = new int[26];
//        for (int i = 0, j = 0; i < s.length(); i++) {
//            sArr[s.charAt(i)-'a']++;
//            if(i-j+1>p.length()){
//                sArr[s.charAt(j)-'a']--;
//                j++;
//            }
//            if(i-j+1==p.length()){
//                if(isArraysEquals(sArr, main)){
//                    list.add(j);
//                }
//            }
//        }
//        return list;
//
//
//    }

    private boolean isArraysEquals(int[] pArr, int[] main) {
        for (int i = 0; i < 26; i++) {
            if (pArr[i] != main[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] main = new int[26];
        for (int i = 0; i < p.length(); i++) {
            main[p.charAt(i) - 'a']++;
        }
        int count = p.length();
        for (int i = 0, j = 0; i < s.length(); ) {
            if (main[s.charAt(i++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                list.add(j);
            }
            if (i - j == p.length() && main[s.charAt(j++) - 'a']++ >= 0) {
                count++;
            }
        }
        return list;


    }

    public int maxScore(int[] cardPoints, int k) {
        int[] ints = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            ints[i + 1] = ints[i] + cardPoints[i];
        }
        int max = 0;
        for (int left = 0, right = cardPoints.length - k; right < ints.length; left++, right++) {
            max = Math.max(max, (ints[left] + (ints[ints.length - 1] - ints[right])));
        }
        return max;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            int z = j;
            while (z <= i) {
                if (Math.abs(nums[z] - nums[i]) <= t) return true;
                z++;
            }
        }
        return false;
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
//        System.out.println(A);
        if (B > A.size()) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        list.add(map.size());
        for (int i = 1, j = i+B-1; j <A.size(); i++, j++) {
            map.put(A.get(i-1), map.get(A.get(i-1))-1);
            if(map.get(A.get(i-1))==0){
                map.remove(A.get(i-1));
            }
            map.put(A.get(j), map.getOrDefault(A.get(j) ,0)+1);
            list.add(map.size());
//            System.out.println(map);
        }
        return list;
    }


}
