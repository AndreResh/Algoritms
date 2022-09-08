package alg.graph_theory_1;

public class FirstDay {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    deleteIsland(grid, i,j);
                }
            }
        }
        return count;
    }

    private void deleteIsland(char[][] grid, int i, int j) {
        if(grid[i][j]=='0') return;
        grid[i][j] = '0';
        if(i>0) deleteIsland(grid, i - 1, j);
        if(i < grid.length-1) deleteIsland(grid, i + 1, j);

        if(j>0) deleteIsland(grid, i , j-1);
        if(j< grid[0].length-1) deleteIsland(grid, i , j+1);
    }
}
