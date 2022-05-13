package alg.dataStructure2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstDay {
    public static void main(String[] args) {
        System.out.println(new FirstDay().threeSum(new int[]{-1,0,1,2,-1,-4}));

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2) {
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public int majorityElement(int[] nums) {
Arrays.sort(nums);
return nums[nums.length/2];
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <3) return Collections.emptyList();
        List<List<Integer>> listList =new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int k = nums.length-1;
        while (true){
            if(i+1>=k){
                break;
            }
            if(nums[i]+nums[i+1]+nums[k]==0){
                if(!listList.contains(List.of(nums[i], nums[i+1], nums[k]))){
                    listList.add(List.of(nums[i], nums[i+1], nums[k]));
                }
                if(nums[i+1]!=0){
                    i++;
                } else {
                    k--;
                }

            } else if(nums[i]+nums[k-1]+nums[k]==0){
                if(!listList.contains(List.of(nums[i], nums[k-1], nums[k]))){
                    listList.add(List.of(nums[i], nums[k-1], nums[k]));
                }
                if(nums[i-1]!=0){
                    k--;
                } else {
                    i++;
                }
                k--;
            } else if (nums[i]+nums[i+1]+nums[k]<0) {
                i++;
            } else {
                k--;
            }
            System.out.println(nums[i]+" "+nums[k]);
        }
        return listList;
    }
}
