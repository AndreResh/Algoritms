package alg.algorithm;

import java.util.Arrays;

public class FourteenthDay {
    public static void main(String[] args) {

    }
//    Reverse Bits

    public int reverseBits(int n) {
        StringBuilder builder = new StringBuilder(Integer.toBinaryString(n));
        builder.reverse();
        while (builder.length()!=32){
            builder.append("0");
        }
        return (int) Long.parseLong(builder.toString(), 2);
    }


//    136. Single Number
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2) {
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
