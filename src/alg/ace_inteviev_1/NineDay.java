package alg.ace_inteviev_1;

public class NineDay {
    public static void main(String[] args) {

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        changeColor(image, sr, sc,image[sr][sc], newColor);
        return image;
    }
    public void changeColor(int[][] image, int i, int j, int oldColor, int newColor){
        if(image[i][j]!=oldColor || image[i][j]==newColor) return;
        image[i][j] = newColor;
        if(i>0) changeColor(image, i-1, j, oldColor, newColor);
        if(i<image.length-1) changeColor(image, i+1, j, oldColor, newColor);

        if(j>0) changeColor(image, i, j-1, oldColor, newColor);
        if(j<image[0].length-1) changeColor(image, i, j+1, oldColor, newColor);
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
