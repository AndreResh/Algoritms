package alg.programming_skills;

import java.util.Arrays;

public class SixDay {
    public static void main(String[] args) {
        System.out.println(new SixDay().sumOddLengthSubarrays(new int[]{10,11,12}));
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] ints = new int[arr.length + 1];
        int sum = 0;
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            sum += arr[i];
            ints[j] = ints[j - 1] + arr[i];
            int k = j - 2;
            while (k > 0) {
                sum += ints[j] - ints[k - 1];
                k -= 2;
            }
            System.out.println(i + " " + sum);
        }
        return sum;
    }
}
