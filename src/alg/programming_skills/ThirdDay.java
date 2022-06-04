package alg.programming_skills;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThirdDay {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
    public int nearestValidPoint(int x, int y, int[][] points) {
        int sum = Integer.MAX_VALUE;
        int index= -1;
        for (int i = 0; i < points.length; i++) {
            if(points[i][0]==x || points[i][1]==y){
                int number = Math.abs(x - points[i][0])+ Math.abs(y - points[i][1]);
                if(number<sum){
                    sum = number;
                    index = i;
                }
            }
        }
        return index;
    }
}
