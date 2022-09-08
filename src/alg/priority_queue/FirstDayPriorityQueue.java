package alg.priority_queue;

import java.util.*;

public class FirstDayPriorityQueue {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> map.get(o2) - map.get(o1)));
        queue.addAll(map.keySet());
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = queue.poll();
        }
        return ints;
    }

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(matrix[i][j]);
            }
        }
        while (k != 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        map.entrySet().stream().sorted(((o1, o2) -> o2.getValue() - o1.getValue())).forEach((o) -> {
            for (int i = 0; i < o.getValue(); i++) {
                builder.append(o.getKey());
            }
        });
        return builder.toString();
    }

    public String[] findRelativeRanks(int[] score) {
        String[] stringsPrices = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Map<Integer, String> map = new HashMap<>();
        int[] ints = Arrays.copyOf(score, score.length);
        Arrays.sort(ints);
        for (int i = ints.length - 1, j = 0; i >= 0; i--, j++) {
            if (j < stringsPrices.length) {
                map.put(ints[i], stringsPrices[j]);
            } else {
                map.put(ints[i], String.valueOf(score.length - i));
            }
        }
        String[] strings = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            strings[i] = map.get(score[i]);
        }
        return strings;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int a : nums) {
            queue.add(a);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int z = 0;
        while (z < k) {
            int a = queue.poll();
            map.put(a, map.getOrDefault(a, 0) + 1);
            z++;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) > 0) {
                int num = map.get(nums[i]);
                res[j++] = nums[i];
                map.put(nums[i], num - 1);
            }
            if (j == res.length) break;
        }
        return res;
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:arr             ) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(map.values());
        int size = arr.length;
        int result = 0;
        while (!queue.isEmpty()){
            int count =0;
            int currentSize = 0;
            while (!queue.isEmpty() && currentSize<size/2){
                currentSize+= queue.poll();;
                count++;
            }
            if(count==0)break;
            result = Math.max(count, result);
            size-=currentSize;
        }
        return result;
    }

    public int solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(A);
        int profit = 0;
        while(B!=0){
            int price = queue.poll();
            profit+=price;
            queue.offer(price-1);
            B--;
        }
        return profit;
    }
}

class KthLargest {
    private int k;
    private Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        int i = k;
        queue.add(val);
        List<Integer> list = new ArrayList<>();
        int current = 0;
        while (i != 0) {
            current = queue.poll();
            list.add(current);
            i--;
        }
        queue.addAll(list);
        return current;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j] == 1 ? 1 : 0;
            }
            map.put(i, sum);
        }
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            int res = map.get(o1) - map.get(o2);
            return res == 0 ? o1 - o2 : res;
        }));
        queue.addAll(map.keySet());
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = queue.poll();
        }
        return ints;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        LOOP:
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i < nums1.length - 1 && nums1[i + 1] * nums2[0] < nums1[i] * nums2[j]) break;
                listList.add(List.of(nums1[i], nums2[j]));
                if (listList.size() == k) break LOOP;
            }
        }
        return listList;
    }
}
//        [3,3,3,3,5,5,5,2,2,7]
//        [7,7,7,7,7,7]
//        [1000,1000,3,7]
//        [9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19]