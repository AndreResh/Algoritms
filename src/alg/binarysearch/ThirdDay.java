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
        int distance = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean isNormal = true;
            for (int j = 0; j < arr2.length; j++) {
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    isNormal = false;
                    break;
                }
            }
            if(isNormal) distance++;
        }
        return distance;
    }

}
