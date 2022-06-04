package alg.dynamicProgramming;

import java.util.*;

public class ThirdDay {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        dp1[0] = nums[0];
        dp2[0] = nums[1];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = Math.max(nums[1], nums[2]);
        int iDp1= 2;
        int iDp2= 2;
        for (int i = 2; i < nums.length; i++) {
            if(i>2){
                dp2[iDp2] = Math.max(dp2[iDp2-1], dp2[iDp2-2]+nums[i]);
                iDp2++;
            }
            if(iDp1<dp1.length){
                dp1[iDp1] = Math.max(dp1[iDp1-1], dp1[iDp1-2]+nums[i]);
                iDp1++;
            }
        }
        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }
    public int deleteAndEarn(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int a = map.get(nums[i]);
                map.put(nums[i], a+nums[i]);
            } else {
                map.put(nums[i], nums[i]);
                list.add(nums[i]);
            }
        }
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int current = 0;
            current += map.get(list.get(i));
            int l = i-1;
            int r = i+1;
            while (l>=0){
                if(list.get(l)+1!=list.get(i)){
                    if(map.get(l)!=null)  current += map.get(l);
                }
                l--;
            }
            while (r<list.size()){
                if(list.get(r)-1!=list.get(i)){
                    if(map.get(r)!=null)  current += map.get(r);
                }
                r++;
            }
            if(current>max){
                max = current;
            }
        }
        return max;
    }
}
