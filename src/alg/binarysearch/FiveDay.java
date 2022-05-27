package alg.binarysearch;

public class FiveDay {
    public static void main(String[] args) {

    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return new int[]{0,0};
        int left = 0;
        int right = nums.length-1;
        int middle;
        while (left<=right){
            middle = (left+right)/2;
            if(nums[middle]==target){
                int l = middle;
                int r = middle;
                while (l>0){
                    if(nums[l-1]==target) {
                        l--;
                    } else {
                        break;
                    }
                }
                while (r<nums.length-1){
                    if(nums[r+1]==target) {
                        r++;
                    } else {
                        break;
                    }
                }
                return new int[]{l,r};
            } else if (nums[middle]>target) {
                right = middle-1 ;
            } else {
                left = middle+1;
            }
        }
        return new int[]{-1,-1};
    }
}
