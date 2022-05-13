package alg.algorithm;

import java.util.Arrays;

public class SecondDay {
    public static void main(String[] args) {
        new SecondDay().rotate(new int[]{1,2}, 3);
//        System.out.println(Arrays.toString(new SecondDay().sortedSquares(new int[]{-4,-1,0,3,10})));
    }
//    nums = [1,2,3,4,5,6,7], k = 3
//           [5,6,7,1,2,3,4]

//    nums = [-1,-100,3,99], k = 2
//    Output: [3,99,-1,-100]

//    [1,2,3,4,5,6] k = 3
//    [4,5,6,1,2,3]
//    [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45]
//            36

//    977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        int[] ints =new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int i = nums.length-1;
        while (left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                ints[i--] = nums[left]*nums[left];
                left++;
            } else {
                ints[i--] = nums[right]*nums[right];
                right--;
            }
        }
        return ints;
    }

//    public void rotate(int[] nums, int k) {
//        int[] copy = Arrays.copyOf(nums, nums.length);
//        int step;
//        for (int i = 0; i < copy.length; i++) {
//            step = i + k;
//            System.out.println(step);
//            while (step>nums.length-1){
//                step -= nums.length;
//            }
//            System.out.println(step);
//            nums[step] = copy[i];
//        }
//
//    }

//    189. Rotate Array
    public void rotate(int[] nums, int k) {

        int length = nums.length-1;

        k = k % nums.length;

        // Reverse first (n-k) elements
        reverse(nums, 0, length-k);

        // Reverse last k elements
        reverse(nums, length-k+1, length);

        // Reverse all n elements
        reverse(nums, 0, length);
    }

    public void reverse(int[] nums, int start, int end) {
        if(start >= nums.length-1) return;
        int left = start;
        int right = end;
        while(left<=right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
