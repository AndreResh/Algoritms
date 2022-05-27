package alg.explore.arrays;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Main().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(new Main().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {

                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public void duplicateZeros(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (newArr[j] == 0) {
                arr[i] = 0;
                if (i + 1 < arr.length) {
                    arr[i + 1] = 0;
                    i++;
                }
            } else {
                arr[i] = newArr[j];
            }
            j++;
        }
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val && nums[right] != val) {
                int a = nums[left];
                nums[left++] = nums[right];
                nums[right--] = a;
            }
            if (nums[left] != val) {
                left++;
            }
            if (nums[right] == val) {
                right--;
            }
        }
        return left;
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public boolean validMountainArray(int[] arr) {
        boolean wasUp = false;
        boolean wasDown = false;
        int i = 1;
        while (i < arr.length && arr[i - 1] < arr[i]) {
            wasUp = true;
            i++;
        }
        while (i < arr.length && arr[i - 1] > arr[i]) {
            wasDown = true;
            i++;
        }
        return wasDown && wasUp && i == arr.length;


//        int N = A.length;
//        int i = 0;
//
//        // walk up
//        while (i+1 < N && A[i] < A[i+1])
//            i++;
//
//        // peak can't be first or last
//        if (i == 0 || i == N-1)
//            return false;
//
//        // walk down
//        while (i+1 < N && A[i] > A[i+1])
//            i++;
//
//        return i == N-1;
    }

    public int[] replaceElements(int[] arr) {
        int[] nums = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(arr[i + 1], max);
            nums[i] = max;
        }
        nums[arr.length - 1] = -1;
        return nums;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0 && nums[left] == 0) {
                int z = nums[right];
                nums[right] = nums[left];
                nums[left] = z;
            }
            if (nums[left] != 0) {
                left++;
            }
            if (nums[right] == 0) {
                right++;
            }
        }
    }

    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int current = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != current) {
                count++;
                current = nums[i];
            }
            if (count == 3) {
                return current;
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}
