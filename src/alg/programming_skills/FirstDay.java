package alg.programming_skills;

import java.util.Arrays;

public class FirstDay {
    public static void main(String[] args) {

    }
    public int countOdds(int low, int high) {
        int a = (high-low)/2;
        if(high%2!=0 || low%2!=0) a++;
        return a;
    }
    public double average(int[] salary) {
        double sum = 0;
        Arrays.sort(salary);
        for (int i = 1; i < salary.length-1; i++){
            sum+=salary[i];
        }
        return sum / (salary.length-2);
    }
    public int[][] transpose(int[][] matrix) {
        int[][] ints = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ints[i][j] = matrix[j][i];
            }
        }
        return ints;
    }
}
