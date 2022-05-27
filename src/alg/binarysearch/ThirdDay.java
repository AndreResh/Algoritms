package alg.binarysearch;

import java.util.Arrays;

public class ThirdDay {
    public static void main(String[] args) {
        System.out.println(new ThirdDay().isPerfectSquare(9));
    }

    public boolean isPerfectSquare(int num) {
//        int left = 0;
//        int right = num;
//        long middle;
//        while (left<=right){
//            middle = (left+right)/2;
//            if(middle * middle == num){
//                return true;
//            } else if (middle*middle>num) {
//                right = (int) (middle - 1);
//            } else {
//                left = (int) (middle + 1);
//            }
//            System.out.println(middle);
//        }
//        return false;


        int a = (int) Math.sqrt(num);
        return Math.pow(a, 2) == num;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int a = binarySearchNearest(arr2, arr1[i]);
            System.out.println(arr1[i] - a);
            if (Math.abs(arr1[i] - arr2[a]) > d) {
                count++;
                if(a+1<=arr2.length-1 && Math.abs(arr1[i] - arr2[a+1]) <= d){
                    count--;
                }
            }
        }
        return count;
    }

    private int binarySearchNearest(int[] arr2, int value) {
        int left = 0;
        int right = arr2.length - 1;
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (arr2[middle] == value) {
                return value;
            } else if (arr2[middle] > value) {

                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
