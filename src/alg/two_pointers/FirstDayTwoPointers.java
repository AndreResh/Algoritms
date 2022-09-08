package alg.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstDayTwoPointers {

    public int[] rearrangeArray(int[] nums) {
        int plus = 0;
        int minus = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[plus] = nums[i];
                plus += 2;
            } else {
                res[minus] = nums[i];
                minus += 2;
            }
        }
        return res;

    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int min = 0;
        int max = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums.length - 1 - i] > pivot) {
                res[max--] = nums[nums.length - 1 - i];

            }
            if (nums[i] < pivot) {
                res[min++] = nums[i];
            }
        }
        while (min <= max) {
            res[min++] = pivot;
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            int res1 = (nums[left] + nums[right] + nums[left + 1]);
            int res2 = (nums[left] + nums[right] + nums[right - 1]);
            if (Math.abs(res1 - target) < Math.abs(res2 - target)) {
                result = Math.min(res1, result);
                right--;
            } else {
                result = Math.max(res2, result);
                left++;
            }
        }
        return result;
    }

    public int waysToSplit(int[] nums) {
        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ints[i] = ints[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < ints.length - 2; i++) {
            count += getCount(ints, i);
        }
        return count;
    }

    private int getCount(int[] ints, int start) {
        int count = 0;
        int first = ints[start];
        for (int i = start + 1; i < ints.length; i++) {
            int second = ints[i] - first;
            int third = ints[ints.length - 1] - second;
            if (first <= second && second <= third) {
                count++;
            } else if (second > third) {
                break;
            }
        }
        return count;
    }

    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isExpressiveWords(s, words[i])) {
                count++;
            }
        }
        return count;
    }

    private boolean isExpressiveWords(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < word1.length() && index2 < word2.length()) {
            if (word1.charAt(index1) == word2.charAt(index2)) {
                int i = index1 + 1;
                int firstCount = 1;
                while (i != word1.length() && word1.charAt(i) == word1.charAt(index1)) {
                    i++;
                    firstCount++;
                }
                int j = index2 + 1;
                int secondCount = 1;
                while (j != word2.length() && word2.charAt(j) == word2.charAt(index2)) {
                    j++;
                    secondCount++;
                }
                if (firstCount != secondCount && (firstCount < 3 || firstCount < secondCount)) {
                    return false;
                }
                index1 = i;
                index2 = j;
            } else {
                return false;
            }
        }
        return index1 >= word1.length() && index2 >= word2.length();
    }

    public boolean buddyStrings(String s, String goal) {
        int wrongIndex = -1;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != goal.charAt(i) && wrongIndex == -1) {
                wrongIndex = i;
            } else {
                return (s.charAt(i) == goal.charAt(wrongIndex) && goal.charAt(i) == s.charAt(wrongIndex));
            }
            i++;
        }
        return s.endsWith(goal);
    }

}

class ATM {
    int[] banknotes = {20, 50, 100, 200, 500};
    int[] atm;

    public ATM() {
        this.atm = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < atm.length; i++) {
            atm[i] += banknotesCount[i];
        }
    }

}
