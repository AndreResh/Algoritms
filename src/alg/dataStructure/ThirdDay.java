package alg.dataStructure;

import java.util.*;

public class ThirdDay {
    public static void main(String[] args) {
        System.out.println(new ThirdDay().maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        Integer count;
        for (int i = 0; i < nums2.length; i++) {
            count = map.get(nums2[i]);
            if (count != null && count > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], count - 1);
            }
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for (int a : list) arr[i++] = a;
        return arr;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
