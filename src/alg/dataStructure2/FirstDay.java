package alg.dataStructure2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstDay {
    public static void main(String[] args) {
        System.out.println(new FirstDay().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    List<List<Integer>> listList = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
         listList = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        existNumber(nums, left, right);
        return listList;
    }

    private void existNumber(int[] nums, int left, int right) {
        if(left<right) return;
        int number = (nums[left]+nums[right]) * -1;
        int l = left+1;
        int r = right-1;
        int middle;
        while (l<=r){
            middle = (nums[l]+nums[r])/2;
            if(nums[middle]==number){
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(nums[middle]);
                if(!listList.contains(list)) listList.add(list);
                break;
            } else if(nums[middle]<r){
                l = middle+1;
            } else {
                r = middle -1;
            }
        }
        existNumber(nums, left+1, right);
        existNumber(nums, left, right-1);
    }
}
