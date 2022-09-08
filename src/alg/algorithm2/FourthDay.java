package alg.algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthDay {
    public static void main(String[] args) {

    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(secondList[j][0], firstList[i][0]);
            int right = Math.min(secondList[j][1], firstList[i][1]);
            if (left <= right) {
                list.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }

        }
        return list.toArray(new int[list.size()][2]);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left<=right){
            int h =  Math.min(height[left], height[right]);
            max = Math.max(max, h * (right-left));
            if(height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
