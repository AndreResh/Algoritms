package alg.algorithm;

import java.util.Arrays;

public class NineDay {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new NineDay().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }

//    542. 01 Matrix
    static boolean[][] booleans;

    public int[][] updateMatrix(int[][] mat) {
        booleans = new boolean[mat.length][mat[0].length];
        boolean isChanged;
        int current = 0;
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[i].length; j++) {
                if(mat[i][j]==current) booleans[i][j] = true;
            }
        }
        while (true) {
            isChanged = false;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if(!booleans[i][j]) {
                        if (i > 0 && mat[i - 1][j] == current && booleans[i - 1][j]) {
                            isChanged = true;
                            mat[i][j] = current + 1;
                            booleans[i][j] = true;
                        } else if (i < mat.length - 1 && mat[i + 1][j] == current && booleans[i + 1][j]) {
                            isChanged = true;
                            mat[i][j] = current + 1;
                            booleans[i][j] = true;
                        } else if (j > 0 && mat[i][j - 1] == current && booleans[i][j-1]) {
                            isChanged = true;
                            mat[i][j] = current + 1;
                            booleans[i][j] = true;
                        } else if (j < mat[i].length - 1 && mat[i][j + 1] == current && booleans[i][j+1]) {
                            isChanged = true;
                            mat[i][j] = current + 1;
                            booleans[i][j] = true;
                        }
                    }

                }
            }
            current++;
            if (!isChanged) {

                break;
            }

        }
        return mat;
    }

    //994. Rotting Oranges
    public int orangesRotting(int[][] grid) {
        int[][] currentArray = new int[grid.length][grid[0].length];
        boolean isChanged;
        boolean haveNormal;
        int count = 0;
        while (true) {
            haveNormal = false;
            isChanged = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        if (i > 0 && grid[i - 1][j] == 2) {
                            isChanged = true;
                            currentArray[i][j] = 2;
                        } else if (i < grid.length - 1 && grid[i + 1][j] == 2) {
                            isChanged = true;
                            currentArray[i][j] = 2;
                        } else if (j > 0 && grid[i][j - 1] == 2) {
                            isChanged = true;
                            currentArray[i][j] = 2;
                        } else if (j < grid[i].length - 1 && grid[i][j + 1] == 2) {
                            isChanged = true;
                            currentArray[i][j] = 2;
                        } else {
                            haveNormal = true;
                            currentArray[i][j] = 1;
                        }
                    } else {
                        currentArray[i][j] = grid[i][j];
                    }
                }
            }
            count++;
            for (int i = 0; i < currentArray.length; i++) {
                grid[i] = Arrays.copyOf(currentArray[i], currentArray[i].length);
            }
            if (!isChanged) {
                break;
            }
        }
        if (haveNormal) {
            return -1;
        } else {
            return count - 1;
        }
    }

}
