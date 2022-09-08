package alg.hash_map;

import java.util.*;

public class SecondDayHashMap {
    public static void main(String[] args) {
        System.out.println(701/26);
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<String, int[]> map = new HashMap<>();
        for (String s : words1) {
            if (map.containsKey(s)) continue;
            map.put(s, getChars(s.toCharArray()));
        }
        int[] ints = new int[26];
        for (String s : words2) {
            fillArr(s.toCharArray(), ints);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            if (isNormal(entry.getValue(), ints)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private boolean isNormal(int[] current, int[] main) {
        for (int i = 0; i < 26; i++) {
            if (main[i] > current[i]) {
                return
                        false;
            }
        }
        return true;
    }

    private void fillArr(char[] chars, int[] ints) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getKey() - 'a';
            ints[index] = Math.max(ints[index], entry.getValue());
        }
    }

    private int[] getChars(char[] toCharArray) {
        int[] ints = new int[26];
        for (char ch : toCharArray) {
            ints[ch - 'a']++;
        }
        return ints;
    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int[] ints = new int[100];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - k > 0) {
                count += ints[nums[i] - 1 - k];
            }
            if (nums[i] + k <= 100) {
                count += ints[nums[i] - 1 + k];
            }
            ints[nums[i] - 1]++;
        }
        return count;

    }

    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (Integer num : A) {
            int current = B ^ num;
            if (set.contains(num)) {
                count++;
            }
            set.add(current);
        }
        return count;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);
        Map<Integer, Integer> map = new HashMap<>();
        addToMap(map, A);
        addToMap(map, B);
        addToMap(map, C);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;

    }

    private void addToMap(Map<Integer, Integer> map, ArrayList<Integer> list) {
        map.put(list.get(0), map.getOrDefault(list.get(0), 0) + 1);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) continue;
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
    }
}
