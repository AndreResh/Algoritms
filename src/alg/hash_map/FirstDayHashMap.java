package alg.hash_map;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class FirstDayHashMap {
    public static void main(String[] args) {
        System.out.println(new BucketSort<Integer>().sort(Arrays.asList(1, 3, 7, -1, 4, 2, -4), (a, b) -> a / b));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strings = paragraph.split("[.,;:?!' ]");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i].toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String current = strings[i].toLowerCase();
            if (!set.contains(current)) {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && !entry.getKey().isEmpty()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            min = Math.min(nums[i], min);
        }
        while (true) {
            if (set.contains(min)) {
                min++;
            } else {
                return min;
            }
        }
    }

    public int minSteps(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int a : ints) {
            if (a > 0) {
                count += a;
            }
        }
        return count;
    }

    public int minDistance(String word1, String word2) {
        int[] ints = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            ints[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            ints[word2.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i != 0) {
                count += Math.abs(ints[i]);
            }
        }
        return count;
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = getNumber(queries[i], nums);
        }
        return result;
    }

    private int getNumber(int[] query, int[] nums) {
        int[] arr = new int[query[1] - query[0] + 1];
        System.arraycopy(nums, query[0], arr, 0, arr.length);
        Arrays.sort(arr);
        int result = -1;
        for (int i = 1, j = 0; i < arr.length; i++) {
            if (nums[i] != nums[j]) {
                result = result == -1 ? nums[i] - nums[j] : Math.min(result, nums[i] - nums[j]);
            }

        }
        return result;
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            if (map.containsKey(copy[i])) {
                continue;
            } else {
                map.put(copy[i], rank++);
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ints = new int[s.length()];
        int sum = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                if (sum == 1) {
                    ints[i] = 0;
                } else {
                    ints[i] = ints[i - 1];
                }
            } else {
                ints[i] = sum++;
            }
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] arr : queries) {
            int left = arr[0];
            int right = arr[1];
            while (left <= right && s.charAt(left) != '|') {
                left++;
            }
            while (left <= right && s.charAt(right) != '|') {
                right--;
            }
            if (left == right) {
                ints[index++] = 0;
            } else {
                ints[index++] = ints[right] - ints[left];
            }
        }
        return result;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int a : map.values()) {
            if (set.contains(a)) return false;
            set.add(a);
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Set<String> seem = new HashSet<>();
        Set<String> result = new HashSet<>();
        LOOP:
        for (String s : words1) {
            if (seem.contains(s)) {
                continue;
            }
            seem.add(s);
            for (String s1 : words2) {
                if (!isSubset(s, s1)) {
                    continue LOOP;
                }
            }
            result.add(s);
        }
        return new ArrayList<>(result);
    }

    private boolean isSubset(String s1, String s2) {
        int[] ints = new int[26];
        for (char ch : s1.toCharArray()) {
            ints[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            ints[ch - 'a']--;
        }
        for (int a : ints) {
            if (a < 0) return false;
        }
        return true;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] a : matches) {
            map.put(a[0], map.getOrDefault(a[0], 0));
            map.put(a[1], map.getOrDefault(a[1], 0) + 1);
        }
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();
        List<Integer> loses = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                winners.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                loses.add(entry.getKey());
            }
        }
        Collections.sort(winners);
        Collections.sort(loses);
        listList.add(winners);
        listList.add(loses);

        return listList;

//        int[] won = new int[100001];
//        int[] loss = new int[100001];
//
//        for(int[] match : matches) {
//            won[match[0]]++;
//            loss[match[1]]++;
//        }
//
//        // System.out.print(Arrays.toString(won));
//        // System.out.print(Arrays.toString(loss));
//
//        List<List<Integer>> ans  = new ArrayList<>();
//
//        List<Integer> wonAllMatches = new ArrayList<>();
//        List<Integer> lostOneMatch = new ArrayList<>();
//
//        for(int i = 0; i < won.length; i++) {
//            if(won[i] > 0 && loss[i] == 0) { //for checking players that have not lost any match.
//                wonAllMatches.add(i);
//            }
//
//            if(loss[i] == 1) {
//                lostOneMatch.add(i); //for checking players that have lost exactly one match.
//            }
//        }
//
//        ans.add(wonAllMatches);
//        ans.add(lostOneMatch);
//
//        return ans;
    }
//
//
}

class BucketSort<T extends Number & Comparable<T>> {
    public List<T> sort(List<T> list, BiFunction<T, Integer, Integer> biFunction) {
        int nOfBts = list.size();
        Map<Integer, List<T>> buckets = new HashMap<>();
        IntStream.range(0, nOfBts).forEach(i -> buckets.put(i, new ArrayList<>()));
        list.forEach(o -> System.out.println((Integer) o / nOfBts));
        list.forEach(item -> buckets.get(biFunction.apply(item, nOfBts)).add(item));
        buckets.values().forEach(Collections::sort);
        return buckets.values().stream().flatMap(Collection::stream).toList();
    }
}