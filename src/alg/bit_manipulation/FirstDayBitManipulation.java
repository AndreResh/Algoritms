package alg.bit_manipulation;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FirstDayBitManipulation {
    public static void main(String[] args) {

        System.out.println(new FirstDayBitManipulation().singleNumber(new ArrayList<>(List.of(890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992 ))));
    }

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int current = 0;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        while (indexA >= 0 || indexB >= 0) {
            int number = current;
            if (indexA >= 0) {
                number += a.charAt(indexA) - '0';
            }
            if (indexB >= 0) {
                number += b.charAt(indexB) - '0';
            }
            builder.append(number % 2);
            current = number / 2;
            indexA--;
            indexB--;
        }
        if (current != 0) builder.append(1);
        builder.reverse();
        return builder.toString();
    }

    public int hammingDistance(int x, int y) {
//        int count = 0;
//
//        for (int i = 0; i < 32; i++) {
//            if((x^y)==1)count++;
//            x = x >> 1;
//            y = y >> 1;
//            System.out.println(x+" "+y);
//        }
//        return count;

//        int newInt = x^y;
//        int count = 0;
//        for(int i=0;i<32;i++){
//            count+=(newInt&1);
//            newInt>>=1;
//        }
//        return count;

        return Integer.bitCount(x ^ y);
    }

    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder builder = new StringBuilder();
        int start = 0;
        while (s.charAt(start) != '1') {
            start++;
        }
        for (int i = start; i < s.length(); i++) {
            builder.append(s.charAt(i) == '1' ? '0' : '1');
        }
        return Integer.parseInt(builder.toString(), 10);
    }

    public int minBitFlips(int start, int goal) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(Integer.toBinaryString(start));
            System.out.println(Integer.toBinaryString(goal));
            count += start ^ goal;
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        if (arr.length < 2) return arr;
        int[] ints = new int[arr.length];
        int[] ints1 = new int[arr.length / 2];
        int[] ints2 = new int[arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1];
        int current = 0;
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = arr[current++];
        }
        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = arr[current++];
        }
        int[] a = sortByBits(ints1);
        int[] b = sortByBits(ints2);
        return mergeByBits(a, b);
    }

    private int[] mergeByBits(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (Integer.bitCount(a[i]) < Integer.bitCount(b[j])) {
                result[k++] = a[i++];
            } else if (Integer.bitCount(b[j]) < Integer.bitCount(a[i])) {
                result[k++] = b[j++];
            } else {
                if (a[i] < b[j]) {
                    result[k++] = a[i++];
                } else {
                    result[k++] = b[j++];
                }
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }

    public int solve(int A) {
        int count = 0;
//        System.out.println(Integer.toBinaryString(A));
        A = ~A;
//        System.out.println(Integer.toBinaryString(A));
        while (true) {
            int b = A & 1;
            System.out.println(b);
            if (b == 1) {
                count++;
            } else {
                return count;
            }
            A >>= 1;
        }
    }

//    public int singleNumber(final List<Integer> A) {
//        int result = 0;
//        for (Integer a : A) {
//            result ^= a;
//        }
//        return result;
//    }

    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int last = A.get(0) ^ A.get(1);
        for (int i = 1; i < A.size(); i++) {
            last = Math.min(last, A.get(i) ^ A.get(i - 1));
        }
        return last;

    }

    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(A.get(i));
            integers.add(A.get(i));
            for (int j = i+1; j < A.size(); j++) {
                int current = list.get(list.size()-1)^A.get(j);
                list.add(current);
                integers.add(current);
            }
        }
//        System.out.println(integers);
        int result = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            result ^= integers.get(i);
        }
        return result;
    }
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (Integer a:A             ) {
            result^=a;
            if(a==0)result^=0;
        }
        return result;
    }

}

