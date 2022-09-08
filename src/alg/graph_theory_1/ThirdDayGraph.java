package alg.graph_theory_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdDayGraph {
    public static void main(String[] args) {
//        System.out.println(new ThirdDayGraph().pacificAtlantic(new int[][]{
//                {3,3,3,3,3,3},
//                {3,0,3,3,0,3},
//                {3,3,3,3,3,3}}));
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(List.of(1,2)));
        lists.add(new ArrayList<>(List.of(2,3)));
        System.out.println(new ThirdDayGraph().solve(4,lists));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> listList = new ArrayList<>();
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights[0].length; i++) {
            pacificAtlantic(heights, 0, i,pacific);
            pacificAtlantic(heights, pacific.length-1, i, atlantic);
        }
        for (int i = 0; i < atlantic.length; i++) {
            pacificAtlantic(heights, i, 0,pacific);
            pacificAtlantic(heights, i, pacific[0].length-1, atlantic);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacific[i][j]==1 && atlantic[i][j]==1)
                    listList.add(List.of(i, j));
            }
        }
        return listList;
    }

    public void pacificAtlantic(int[][] heights, int i, int j,  int[][] ocean) {
        if (ocean[i][j]==1) return;
        ocean[i][j] = 1;
        if (i > 0 && heights[i - 1][j] >= heights[i][j]) {
            pacificAtlantic(heights, i - 1, j, ocean);
        }
        if (j < heights[i].length - 1 && heights[i][j + 1] >= heights[i][j]) {
            pacificAtlantic(heights, i, j + 1, ocean);
        }
        if (i < heights.length - 1 && heights[i + 1][j] >= heights[i][j]) {
            pacificAtlantic(heights, i + 1, j, ocean);
        }
        if (j > 0 && heights[i][j - 1] >= heights[i][j]) {
            pacificAtlantic(heights, i, j - 1, ocean);
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        GraphA graph = new GraphA(A);
        for(ArrayList<Integer> list: B){
            graph.union(list.get(0)-1, list.get(1)-1);
        }
        return graph.getComponents();
    }

}
class GraphA{
    int components;
    int[] root;
    int[] rank;
    GraphA(int size){
        this.components = size;
        this.root = new int[size];
        this.rank = new int[size];
        for(int i = 0; i< size; i++){
            this.root[i] = i;
        }
        for(int i = 0; i< size; i++){
            this.rank[i] = 1;
        }
    }
    int find(int x){
        if(root[x]==x) return x;
        return find(root[x]);
    }

    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            this.components--;
            if(rank[rootX]==rank[rootX]){
                root[rootY] = rootX;
                rank[rootX]++;
            } else if(rank[rootX]<rank[rootY]){
                root[rootX] = rootY;
            } else{
                root[rootY] = rootX;
            }

        }
        System.out.println(Arrays.toString(root));
    }
    int getComponents(){
        return this.components;
    }
}