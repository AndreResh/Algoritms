package alg.prefix_sum;

import java.util.*;

public class FirstDayPrefixSum {
    public static void main(String[] args) {
        System.out.println(new FirstDayPrefixSum().solve(new ArrayList<>(List.of(2, 1, 6, 4))));
    }

    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        k = k % sum;
        sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        return -1;
    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int[] ints = new int[100];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - k > 0) {
                count += ints[nums[i] - k];
            }
            if (nums[i] + k < 100) {
                count += ints[nums[i] + k];
            }
            ints[nums[i]]++;
        }
        return count;

    }

    public int solve(ArrayList<Integer> A, int B) {
        int[] arr = new int[A.size() + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + A.get(i - 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = arr.length - 1 - B; i <= B; i++, j++) {
            int current = arr[i];
            current += arr[arr.length - 1] - arr[j];
            max = Math.max(current, max);
        }
        return max;

    }

    public int solve(ArrayList<Integer> A) {
        System.out.println(A);
        System.out.println();
        int[] evenUp = new int[A.size()];
        int[] oddUp = new int[A.size()];
        int[] evenDown = new int[A.size()];
        int[] oddDown = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) {
                evenUp[i] += A.get(i);
            } else {
                oddUp[i] += A.get(i);
            }
            evenUp[i] += i > 0 ? evenUp[i - 1] : 0;
            oddUp[i] += i > 0 ? oddUp[i - 1] : 0;
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                evenDown[i] += A.get(i);
            } else {
                oddDown[i] += A.get(i);
            }
            evenDown[i] += i < A.size() - 1 ? evenUp[i + 1] : 0;
            oddDown[i] += i < A.size() - 1 ? oddDown[i + 1] : 0;
        }
        System.out.println(Arrays.toString(oddUp));
        System.out.println(Arrays.toString(oddDown));
        System.out.println(Arrays.toString(evenUp));
        System.out.println(Arrays.toString(evenDown));

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            System.out.println((i > 0 ? evenUp[i - 1] : 0) + " " + (i < A.size() - 1 ? oddDown[i + 1] : 0) + " " + (i > 0 ? oddUp[i - 1] : 0) + " " + (i < A.size() - 1 ? evenDown[i + 1] : 0));
            if ((i > 0 ? evenUp[i - 1] : 0) + (i < A.size() - 1 ? oddDown[i + 1] : 0) == (i > 0 ? oddUp[i - 1] : 0) + (i < A.size() - 1 ? evenDown[i + 1] : 0))
                count++;


        }
        return count;
    }

    public int romanToInt(String A) {
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] ints = {1, 5, 10, 50, 100, 500, 1000};
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            switch (A.charAt(i)){
                case 'I':
                    if(i<A.length()-1 && (A.charAt(i+1)=='X' ||A.charAt(i+1)=='V' )){
                        result-=1;
                    } else {
                        result+=1;
                    }
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    if(i<A.length()-1 && (A.charAt(i+1)=='L' ||A.charAt(i+1)=='C' )){
                        result-=10;
                    } else {
                        result+=10;
                    }
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    if(i<A.length()-1 && (A.charAt(i+1)=='D' ||A.charAt(i+1)=='M' )){
                        result-=100;
                    } else {
                        result+=100;
                    }
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }
        }
        return result;
    }
}

class NumArray {
    List<Integer> list;

    public NumArray(int[] nums) {
        this.list = new ArrayList<>();
        list.add(0);
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i] + list.get(list.size() - 1));
        }
    }

    public void update(int index, int val) {
        int num = index == 0 ? val : list.get(index) + val;
        int prev = list.get(index + 1);
        list.set(index + 1, num);
        for (int i = index + 2; i < list.size(); i++) {
            list.set(i, list.get(i) + val - prev);
        }
    }

    public int sumRange(int left, int right) {
        System.out.println(list);
        return list.get(right + 1) - list.get(left);
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        int count = 1;
        for (int i = 1, j = 1; i < a.size(); i++) {
            if(!a.get(i).equals(a.get(i-1))){
                count++;
                a.set(j++, a.get(i));
            }
        }
        return count;
    }
}