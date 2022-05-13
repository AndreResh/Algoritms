package alg.dataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstDay {
    public static void main(String[] args) {
        System.out.println(new FirstDay().maxSubArray(new int[]{5,4,-1,7,8}));
    }
    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        int prev = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i]==prev){
//                return true;
//            }
//            prev=nums[i];
//        }
//        return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max =nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i]>sum){
                sum=nums[i];
            }
            max = Math.max(sum,max);
        }
        return Math.max(sum,max);
    }

}
