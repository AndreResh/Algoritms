package alg.explore.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][] isConnected) {
        int[] ints = new int[isConnected.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j]==1){
                    union(ints, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]==i) count++;
        }
        return count;
    }

    private void union(int[] ints, int i, int j) {
        int x = find(ints, i);
        int y = find(ints, j);
        if(ints[y]!=ints[x]){
            ints[y] = x;
        }
    }
    private int find(int[] ints, int value){
        if(value==ints[value]){
            return value;
        }
        return ints[value] = find(ints, ints[value]);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        String result = s;
        for (int i = 0; i < pairs.size(); i++) {
            char[] chars = s.toCharArray();
            swap(chars, pairs.get(i));
            if(result.equals(s) || String.valueOf(chars).compareTo(result)>0){
                result = String.valueOf(chars);
            }

        }
        return result;
    }

    private void swap(char[] chars, List<Integer> integers) {
        char z = chars[integers.get(0)];
        chars[integers.get(0)] = chars[integers.get(1)];
        chars[integers.get(1)] = z;
    }
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}
