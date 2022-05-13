package alg.algorithm;

public class FirstDay {
//    Binary Search
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int half;
        while (true) {
            half = (min + max) / 2;
            if (target == nums[half]) {
                return half;
            }
            if (min >= max) {
                return -1;
            }
            if (nums[half] > target) {
                max = half - 1;
            } else {
                min = half + 1;
            }
        }
    }

//    278. First Bad Version
    //    isBadVersion()
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

//    35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int half;
        while (true) {
            half = (min + max) / 2;
            if (target == nums[half]) {
                return half;
            }
            if (min > max) {
                return min;
            }
            if (nums[half] > target) {
                max = half - 1;
            } else {
                min = half + 1;
            }
        }
    }

    private boolean isBadVersion(int half) {
        if (half >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
