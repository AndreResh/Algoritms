package alg.algorithm;

import java.util.*;

public class TwelveDay {
    public static void main(String[] args) {
        System.out.println(new TwelveDay().climbStairs(44));
    }
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        map.put(n-1, 1);
        map.put(n-2, 2);
        map.put(n+1, 0);
        int current = n-3;
        while (current>-1){
            current = climb(current);
            current--;
        }
        return map.get(0);
    }

    private int climb( int current) {
        if(map.containsKey(current)){
            return map.get(current);
        }
        int a = climb(current+1);
        int b = climb( current+2);
        map.put(current, a+b);
        return current;
    }
//    public int rob(int[] nums) {
//        int sum = 0;
//        int current = 0;
//        for (int i = 0; i < nums.length ; i++) {
//            current += nums[i];
//            if(current)
//        }
//        return Math.max(max1, max2);
//    }


    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = triangle.size()-1; i >=0 ; i--) {
            List<Integer> nums = new ArrayList<>();
            if (i==triangle.size()-1){
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    nums.add(triangle.get(i).get(j));
                }
            } else {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    nums.add(Math.min(listList.get(listList.size()-1).get(j), listList.get(listList.size()-1).get(j+1))+triangle.get(i).get(j));
                }
            }

            listList.add(nums);
        }
       return listList.get(listList.size()-1).get(0);

    }

}
