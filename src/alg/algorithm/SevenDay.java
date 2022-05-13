package alg.algorithm;

import java.util.Arrays;

public class SevenDay {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SevenDay().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }

    //695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getIsland(grid, 0, i, j));
                }
            }
        }
        return max;
    }

    private int getIsland(int[][] grid, int area, int i, int j) {
        if (grid[i][j] == 0) return area;
        grid[i][j] = 0;
        area++;
        if (i > 0) {
            area = getIsland(grid, area, i - 1, j);
        }
        if (i < grid.length - 1) {
            area = getIsland(grid, area, i + 1, j);
        }
        if (j > 0) {
            area = getIsland(grid, area, i, j - 1);
        }
        if (j < grid[0].length - 1) {
            area = getIsland(grid, area, i, j + 1);
        }
        return area;
    }

//    733. Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startPixel = image[sr][sc];
        startFlood(image, sr, sc, newColor, startPixel);
        return image;
    }

    private void startFlood(int[][] image, int sr, int sc, int newColor, int startPixel) {
        if(image[sr][sc]!=startPixel || image[sr][sc]==newColor) return;
        image[sr][sc] = newColor;
        if(sr > 0){
            startFlood(image,sr-1,sc, newColor, startPixel);
        }
        if(sr < image.length-1){
            startFlood(image,sr+1,sc, newColor, startPixel);
        }
        if(sc>0){
            startFlood(image,sr,sc-1, newColor, startPixel);
        }
        if(sc < image[0].length-1){
            startFlood(image,sr,sc+1, newColor, startPixel);
        }
    }
}
