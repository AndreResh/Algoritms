package alg.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecondDay {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SecondDay().twoSum(new int[]{3,3},6)));
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr =new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])!=null){
                arr[0]= map.get(nums[i]);
                arr[1]= i;
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i], i);
        }
        return arr;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums0 =Arrays.copyOf(nums1,nums1.length);
        int k =0;
        int a =0;
        int b=0;
        while (m>0 && n>0){
            if(nums0[a]<nums2[b]){
                nums1[k++] = nums0[a++];
                m--;
            } else {
                nums1[k++] = nums2[b++];
                n--;
            }
        }
        while (m>0){
            nums1[k++] = nums0[a++];
            m--;
        }
        while (n>0){
            nums1[k++] = nums2[b++];
            n--;
        }
    }
}
