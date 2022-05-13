package alg.binarysearch;

public class FirstDay {
    public static void main(String[] args) {
        System.out.println(new FirstDay().search(new int[]{-1,0,3,5,9,12}, 3));
    }
//    public int guessNumber(int n) {
//        int left = 1;
//        int right = n;
//        int middle;
//        while (left<=right){
//            middle = left + (right-left)/2;
//            int res = guess(middle);
//            if (res==0){
//                return middle;
//            } else if(res<0){
//                right = middle-1;
//            } else {
//                left = middle+1;
//            }
//        }
//        return -1;
//    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle;
        while (left<=right){
            middle = (right+left)/2;
            if (nums[middle]==target){
                return middle;
            } else if(nums[middle]>target){
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return -1;
    }
}
