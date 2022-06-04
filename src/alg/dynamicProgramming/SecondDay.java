package alg.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class SecondDay {
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
        int b = climb(current+2);
        map.put(current, a+b);
        return current;
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] ints = new int[cost.length];
        ints[0] = cost[0];
        ints[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            ints[i]  = cost[i]+Math.min(ints[i-1], ints[i-2]);
        }
        return Math.min(ints[ints.length-1], ints[ints.length-2]);
    }
}
