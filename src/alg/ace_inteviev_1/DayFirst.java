package alg.ace_inteviev_1;

import java.util.Arrays;

public class DayFirst {
    public static void main(String[] args) {
//        System.out.println(new DayFirst().pivotIndex(new int[]{1,7,3,6,5,6}));
        int n1 = 3;
        int n2 = 5;

        int result = n1 | n2;
        System.out.println(result);
    }
//    public int pivotIndex(int[] nums) {
//        int[] ints = new int[nums.length+1];
//        for (int i = 1; i < ints.length; i++) {
//            ints[i] = ints[i-1]+nums[i-1];
//        }
//        for (int i = 1; i < ints.length; i++) {
//            if(ints[ints.length-1]-ints[i]==ints[i-1]){
//                return i-1;
//            }
//        }
//        return -1;
//    }
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
