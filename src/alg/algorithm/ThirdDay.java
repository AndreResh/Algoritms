package alg.algorithm;

import java.util.Arrays;

public class ThirdDay {
    public static void main(String[] args) {
//        new ThirdDay().moveZeroes(new int[]{0,1,0,3,12});
        System.out.println(Arrays.toString(new ThirdDay().twoSum(new int[]{-1,0},-1)));
    }
//    283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        while (j<nums.length){
            nums[j++]=0;
        }
    }

//    167. Two Sum II - Input Array Is Sorted
    public int[] twoSum(int[] numbers, int target) {
//        int[] ints=new int[2];
//        int i = numbers.length-1;
//        int j = 0;
//        while (i<j){
//            if(numbers[i]+numbers[j]==target){
//                ints[0]=j+1;
//                ints[1]=i+1;
//                break;
//            } else if(numbers[j]+numbers[i]>target){
//                i--;
//            } else {
//                j++;
//            }
//        }
//        return ints;
        int left = 0;
        int right = numbers.length-1;
        int middle;
        while (left<right){
            middle = numbers[left]+numbers[right];
            if(middle==target){
                return new int[]{numbers[left],numbers[right]};
            } else if (middle<target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
