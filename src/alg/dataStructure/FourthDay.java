package alg.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthDay {
    public static void main(String[] args) {
        List<List<Integer>> list = new FourthDay().generate(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> last = List.of(1);
        list.add(last);
        for (int i = 0; i < numRows-1; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 1; j < last.size(); j++) {
                newList.add(last.get(j)+last.get(j-1));
            }
            newList.add(1);
            list.add(newList);
            last = newList;
        }
        return list;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] arr = new int[r][c];
        int k = 0;
        int l = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (l <= arr[k].length - 1) {
                    arr[k][l++] = mat[i][j];
                } else {
                    l = 0;
                    arr[++k][l++] = mat[i][j];
                }
            }
        }
        return arr;
    }
}
