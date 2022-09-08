package alg.dynamicProgramming;

import java.util.*;
class A{
    protected int a;
}
//"rabbbit" , "rabbit"
public class SecondDayDP {
    public static void main(String[] args) {

    }


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        LOOP:
        while (amount != 0) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (amount % coins[i] == 0) {
                    amount -= coins[i];
                    count++;
                    continue LOOP;
                }
            }
            return -1;

        }
        return count;
    }

    public int findLongestChain(int[][] pairs) {
//        Arrays.sort(pairs, ((o1, o2) -> {
//            if(o1[0]==o2[0]){
//                return o1[1]-o2[1];
//            } else {
//                return o1[0]-o2[0];
//            }
//        }));
//        for (int[] a:pairs             ) {
//            System.out.println(Arrays.toString(a));
//        }
//        LinkedList<int[]> list = new LinkedList<>();
//        for (int[] ints : pairs) {
//            if(list.isEmpty()) list.add(ints);
//            if(list.getLast()[1]<ints[0]) list.add(ints);
//        }
//        return list.size();
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int a : dp) {
            max = Math.max(a, max);
        }
        return max;
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> listList = new HashSet<>();

        findSubsequences(nums, 0, listList, new ArrayList<>());
        return new ArrayList<>(listList);
    }

    private void findSubsequences(int[] nums, int start, Set<List<Integer>> listList, List<Integer> list) {
        if (list.size() > 1) listList.add(new ArrayList<>(list));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                findSubsequences(nums, i + 1, listList, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public int numFactoredBinaryTrees(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], 1);
        }
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (map.containsKey(A[i] / A[j]))
                    sum += map.get(A[j]) * map.get(A[i] / A[j]);
            }
            map.put(A[i], sum);
        }
        int sim = 0;
        for (Integer a : map.values()) {
            sim += a;
        }
        return sim;
    }
    public int longestSubsequenceLength(final List<Integer> A) {
        int[] up = new int[A.size()];
        int[] down = new int[A.size()];
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(A.get(j)<A.get(i)){
                    up[i] = Math.max(up[i], up[j]+1);
                }
            }
        }
        // System.out.println(Arrays.toString(up));
        for (int i = A.size()-2; i >=0 ; i--) {
            for (int j = A.size()-1; j > i ; j--) {
                if(A.get(i)>A.get(j)){
                    down[i] = Math.max(down[i], down[j]+1);
                }
            }

        }
        // System.out.println(Arrays.toString(down));
        int result = 0;
        for (int i = 0; i < A.size(); i++) {

            result = Math.max(result, up[i]+down[i]+1);

        }
        return result;
    }

}
