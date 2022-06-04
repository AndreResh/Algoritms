package alg.dataStructure2;

import java.util.Arrays;
import java.util.Comparator;

public class FourthDay {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]>target) return false;
            if(containsInSubArray(matrix[i], target)){
                return true;
            }

        }
        return false;
    }

    private boolean containsInSubArray(int[] matrix, int target) {

        int left = 0;
        int right = matrix.length-1;
        int middle;
        while (left<=right){
            middle = (left+right)/2;
            if(matrix[middle]==target) {
                return true;
            } else if (matrix[middle]<target) {

                left = middle +1;
            } else {
                right = middle-1;
            }
        }
        return false;
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((o)->o[0]));
        int count = 0;
        for(int[] a :intervals){
            System.out.println(Arrays.toString(a));
        }
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][1]<=intervals[i-1][1]){
                count++;
            }
        }
        return count;
    }
}
