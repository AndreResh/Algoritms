package alg.two_pointers;

import java.util.*;

public class SecondDayTwoPointers {
    public static void main(String[] args) {
        System.out.println(new SecondDayTwoPointers().reverse(3));
    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length-2; i >=0; i--) {
            if(nums[i]<nums[i+1]){
                int j = nums.length-1;
                while (i<j){
                    if(nums[j]>nums[i]) break;
                    j--;
                }
                int ch = nums[i];
                nums[i] = nums[j];
                nums[j]= ch;
                reverse(nums, i+1, nums.length-1);
                return ;
            }
        }
        reverse(nums, 0, nums.length-1);
    }
    private void reverse(int[] nums, int left, int right){
        while(left<right){
            int a = nums[left];
            nums[left] = nums[right];
            nums[right] = a;
            left++;
            right--;
        }
    }

    public int longestOnes(int[] nums, int k) {
        if(k==0){
            int count = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==1){
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }
            return max;
        }
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            count++;
            if (nums[i] == 0) {
                if (queue.size() == k) {
                    int poll = queue.poll();
                    count -= prefixSum[poll];
                }
                queue.offer(i);
            }

            if (i != 0) {
                prefixSum[i] = count;
            }
            max = Math.max(count, max);
        }
        System.out.println(Arrays.toString(prefixSum));
        return max;
    }

    public long reverse(long a) {
        System.out.println(Long.toBinaryString(a));
        return Long.parseLong(new StringBuilder(Long.toBinaryString(a)).reverse().toString());
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int i = 0;
        for (int j = 0; j < a.size(); j++) {
            if(!a.get(j).equals(b)){
                a.set(i++, a.get(j));
            }
        }
        return i;
    }

    public void sortColors(ArrayList<Integer> a) {
        int zeroes = 0;
        int ones = 0;
        for(Integer num: a){
            if(num==0){
                zeroes++;
            } else if(num==1){
                ones++;
            }
        }
        int size = a.size();
        a.clear();
        for(int i = 0; i < size; i++){
            if(zeroes>0){
                a.add(0);
                zeroes--;
            } else if(ones>0){
                a.add(1);
                ones--;
            } else{
                a.add(2);
            }
        }
    }

}
