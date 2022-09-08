package alg.graph_theory_1;

public class ThirdDay {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                deleteIslands(grid, 0, i);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[grid.length - 1][i] == 1) {
                deleteIslands(grid, grid.length - 1, i);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                deleteIslands(grid, i, 0);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length-1] == 1) {
                deleteIslands(grid, i, grid[0].length-1);
            }
        }
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void deleteIslands(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        if (i > 0) deleteIslands(grid, i - 1, j);
        if (i < grid.length - 1) deleteIslands(grid, i + 1, j);

        if (j > 0) deleteIslands(grid, i, j - 1);
        if (j < grid[0].length-1) deleteIslands(grid, i, j+1);
    }



}
