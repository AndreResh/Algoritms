package alg.graph_theory_1;

public class SecondDay {
    public static void main(String[] args) {

    }
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==0) {
                    if (isClosedIsland(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j) {
        if(grid[i][j]==1) return true;
        grid[i][j] = 1;
        boolean first = false;
        if(i>0){
            first = isClosedIsland(grid, i - 1, j);
        }
        boolean second= false;
        if(i< grid.length-1){
            second = isClosedIsland(grid, i + 1, j);
        }
        boolean third= false;
        if(j>0){
            third = isClosedIsland(grid, i , j-1);
        }
        boolean fourth = false;
        if(j< grid[0].length-1){
            fourth = isClosedIsland(grid, i , j+1);
        }
        return  first && second && third && fourth;


    }
}
