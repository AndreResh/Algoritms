package alg.math;

import java.util.*;

public class FirstDayMath {
    public static void main(String[] args) {
        System.out.println(new FirstDayMath().convertToTitle(28));
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);

        rotateMatrix(matrix);
    }

    private void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            while (left < right) {
                int a = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = a;
                left++;
                right--;
            }
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
    }

    public int[] plusOne(int[] digits) {
        int current = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ints = new int[digits.length];
        ints[0] = 1;
        return ints;
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int average = nums[nums.length / 2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != average) {
                sum += Math.abs(nums[i] - average);
            }
        }
        return sum;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous + 1) {
                count++;
                previous = nums[i];
            } else if (nums[i] != previous) {
                max = Math.max(max, count);
                count = 1;
                previous = nums[i];
            }
        }

        return Math.max(max, count);


//        Set<Integer> set = new HashSet<>();
//        Set<Integer> previous = new HashSet<>();
//        for (int i : nums) {
//            set.add(i);
//        }
//        int max = 1;
//        for (int a : set) {
//            if (!set.contains(a - 1) || !previous.contains(a)) {
//                int currentNumber = a;
//                int count = 1;
//                while (set.contains(a+1)){
//                    previous.add(a);
//                    count++;
//                    currentNumber++;
//                }
//                max = Math.max(max, count);
//            }
//        }
//        return max;
    }

    public long[] sumOfThree(long num) {
        long b = num / 3;
        if (b - 1 + b + b + 1 == num) {
            return new long[]{b - 1, b, b + 1};
        } else {
            return new long[]{};
        }
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = special[0] - bottom;
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return Math.max(max, top - special[special.length - 1]);
    }

    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] ints = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            ints[i - 1] = nums[i - 1] + nums[i];
        }
        return triangularSum(ints);
    }

    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] ints = new int[nums.length / 2];
        for (int i = 1, j = 0; i < nums.length; i += 2, j++) {
            ints[j] = j % 2 == 0 ? Math.min(nums[i], nums[i - 1]) : Math.max(nums[i], nums[i - 1]);
        }
        return minMaxGame(ints);
    }

    public int lastRemaining(int n) {
        if (n == 1) return 1;
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        return findLastRemaining(arr, true);
    }

    private int findLastRemaining(int[] arr, boolean left) {
        if (arr.length == 1) return arr[0];
        int[] ints = new int[arr.length / 2];
        if (left) {
            for (int i = 0, j = 0; i < arr.length; i += 2, j++) {
                ints[j] = arr[i];
            }
        } else {
            for (int i = arr.length - 1, j = ints.length - 1; i >= 0; i -= 2, j--) {
                ints[j] = arr[i];
            }
        }
        return findLastRemaining(ints, !left);
    }

    public int titleToNumber(String columnTitle) {
        int result = columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1;
        for (int i = columnTitle.length()-2, j = 0; i >=0 ; i--, j++) {
            result +=(Math.pow(26, j)*(columnTitle.charAt(i) - 'A' + 1));
        }
        return result;
    }

    public boolean isUgly(int n) {
        Set<Integer> uglyNumbers = new HashSet<>();
        Set<Integer> notUgly = new HashSet<>();
        notUgly.add(7);
        for (int i = 2; i < 7; i++) {
            uglyNumbers.add(i);
        }
        for (int i = 7; i < n; i++) {
            if(n%i==0 && !isNumberUgly(i, uglyNumbers, notUgly)) return false;
            uglyNumbers.add(i);
        }
        return true;
    }

    private boolean isNumberUgly(int number, Set<Integer> uglyNumbers, Set<Integer> notUgly) {
        for (int j = 2; j < number; j++) {
            if(notUgly.contains(j) && number%j==0){
                return false;
            }

        }
        return true;
    }
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        double a =  Math.log10(n)/Math.log10(3.0);
        System.out.println(a);
        return Math.ceil(a)==a;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber!=0){
            int j = 1;
            double current = Math.pow(26, j);
            while (current<=columnNumber){
                j++;
                current = Math.pow(26, j);

            }
            j--;

            columnNumber-=Math.pow(26, j);
            System.out.println(columnNumber);
            builder.append((char) ('A'+j));
        }
        return builder.reverse().toString();
//        for (int i = columnTitle.length()-2, j = 0; i >=0 ; i--, j++) {
//            result +=(Math.pow(26, j)*(columnTitle.charAt(i) - 'A' + 1));
//        }
//        return result;
    }

}
