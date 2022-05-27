package alg.algorithm;

import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

public class ThirteenthDay {
    public static void main(String[] args) {
//        int[] ints = new int[]{-10,-3,5,9};
//        System.out.println(ints[ints.length/2]);
//        System.out.println(9/1000);
//        System.out.println(8/5);
//        System.out.println(new ThirteenthDay().intToRoman(58));
//        System.out.println(new ThirteenthDay().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
//        System.out.println(new ThirteenthDay().convertToTitle(701));
//        System.out.println(int[] a =null;
//        System.out.println(new ThirteenthDay().c());
//        System.out.println(new ThirteenthDay().hammingWeight(4294967293));
    }
//@Target()
    Map<Integer, String> mapOfRomans1 = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M",
            4, "IV", 9, "IX", 40, "XL");
    Map<Integer, String> mapOfRomans2 = Map.of(90, "XC", 400, "CD", 900, "CM");
    static int num;

    public String intToRoman(int num) {
        this.num = num;
        String s = "";
        while (this.num != 0) {
            if (this.num / 1000 > 0) {
                s = getNewString(s, 1000);
            } else if (this.num / 900 > 0) {
                s = getNewString(s, 900);
            } else if (this.num / 500 > 0) {
                s = getNewString(s, 500);
            } else if (this.num / 400 > 0) {
                s = getNewString(s, 400);
            } else if (this.num / 100 > 0) {
                s = getNewString(s, 100);
            } else if (this.num / 90 > 0) {
                s = getNewString(s, 90);
            } else if (this.num / 50 > 0) {
                s = getNewString(s, 50);
            } else if (this.num / 40 > 0) {
                s = getNewString(s, 40);
            } else if (this.num / 10 > 0) {
                s = getNewString(s, 10);
            } else if (this.num / 9 > 0) {
                s = getNewString(s, 9);
            } else if (this.num / 5 > 0) {
                s = getNewString(s, 5);
            } else if (this.num / 4 > 0) {
                s = getNewString(s, 4);
            } else {
                s = getNewString(s, 1);
            }
        }
        return s;
    }

    public String getNewString(String s, int current) {
        int a = this.num / current;
        for (int i = 0; i < a; i++) {
            if (mapOfRomans1.containsKey(current)) {
                s += mapOfRomans1.get(current);
            } else {
                s += mapOfRomans2.get(current);
            }

        }
        this.num -= a * current;
        return s;
    }

    public int minPathSum(int[][] grid) {
        int[][] ints = new int[grid.length][grid[0].length];
        ints[ints.length - 1][ints[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = ints[0].length - 2; i >= 0; i--) {
            ints[ints.length - 1][i] = grid[ints.length - 1][i] + grid[ints.length - 1][i + 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (j == grid[i].length - 1) {
                    ints[i][j] = grid[i][j] + ints[i + 1][j];
                } else {
//                    System.out.println(grid[i][j]+" "+grid[i+1][j]+" "+grid[i][j+1]);
                    ints[i][j] = Math.min(grid[i][j] + ints[i + 1][j], grid[i][j] + ints[i][j + 1]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(ints));
        return ints[0][0];
    }

    public int hammingWeight(int n) {
        int count = 0;
        char[] s = Integer.toBinaryString(n).toCharArray();
        for (char ch: s){
            if(ch=='1') count++;
        }
        return count;
    }

    public boolean isPowerOfTwo(int n) {
        int left = 0;
        int right = n;
        int middle;
        while (left<right){
            middle = (left+right)/2;
            if(Math.pow(2, middle)==n){
                return true;
            } else if (Math.pow(2, middle)>n) {
                right = middle;

            } else {
                left = middle+1;
            }
        }
        return false;
    }

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        ints[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ints[i] = Math.max(nums[i]+ints[i-2], ints[i-1]);
        }
        return ints[ints.length-1];
    }

}
