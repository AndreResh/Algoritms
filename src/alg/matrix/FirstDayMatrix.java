package alg.matrix;

import java.util.*;

public class FirstDayMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FirstDayMatrix().diagonalSort(new int[][]{{3,3,1,1}, {2,2,1,2},{2,2,1,2}})));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = matrix.length;
        int l = matrix[0].length;
        boolean[][] booleans = new boolean[matrix.length][matrix[0].length];
        while (i < k && j < l) {
            for (int m = j; m < l; m++) {
                if (!booleans[i][m]) {
                    list.add(matrix[i][m]);
                    booleans[i][m] = true;
                }
            }
            for (int m = i + 1; m < k; m++) {
                if (!booleans[m][l - 1]) {
                    list.add(matrix[m][l - 1]);
                    booleans[m][l - 1] = true;
                }

            }
            for (int m = l - 2; m >= j; m--) {
                if (!booleans[k - 1][m]) {
                    list.add(matrix[k - 1][m]);
                    booleans[k - 1][m] = true;
                }

            }
            for (int m = k - 2; m > i; m--) {
                if (!booleans[m][j]) {
                    list.add(matrix[m][j]);
                    booleans[m][j] = true;
                }

            }
            i++;
            j++;
            k--;
            l--;
        }
        return list;
    }
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int i = 0;
        int j = 0;
        int k = n - 1;
        int l = n - 1;
        int number = 1;
        while (i <= k) {
            for (int m = j; m < ints[i].length - j; m++) {
                ints[i][m] = number++;
            }
            for (int m = i + 1; m < ints.length - i; m++) {
                ints[m][l] = number++;
            }
            for (int m = l - 1; m >= i; m--) {
                ints[k][m] = number++;
            }
            for (int m = k - 1; m > i; m--) {
                ints[m][j] = number++;
            }
            i++;
            j++;
            k--;
            l--;
        }
        return ints;
    }

    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                queue.offer(mat[i][j]);
            }
        }
        int[][] ints = new int[mat.length][mat[0].length];
        int i = 0;
        int j = 0;
        while (i<ints.length && j< ints[i].length){
            int k = i;
            int l = j;
            while (k<ints.length || l<ints[i].length){
                if(l<ints[i].length) {
                    ints[i][l] = queue.poll();
                }
                if(k!=i && k< ints.length){
                    ints[k][j] = queue.poll();
                }
                k++;
                l++;
            }
            i++;
            j++;
        }
        return ints;
    }

    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.size();i+=2) {
            list.add(A.get(i));
            if(i<A.size()-1) list.add(i, A.get(i+1));
        }
        return list;
    }




}
