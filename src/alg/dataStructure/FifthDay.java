package alg.dataStructure;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FifthDay {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet;
        for (int i = 0; i < board.length; i++) {
            rowSet =new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(i%3==0 && j%3==0){
                    if(!isValidBox(board, i,j)) return false;
                }
                if (i == 0){
                    if(!isValidColumn(board, j)){
                        return false;
                    }
                }
                if (rowSet.contains(board[i][j])){
                    return false;
                }
                if(Character.isDigit(board[i][j])) {
                    rowSet.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int i, int j) {
        Set<Character> set =new HashSet<>();
        for (int k = i; k < 3; k++) {
            for (int l = j; l < 3; l++) {
                if(set.contains(board[k][l])){
                    return false;
                }
                if(Character.isDigit(board[k][l])){
                    set.add(board[k][l]);
                }
            }
        }
        return true;
    }
    private boolean isValidColumn(char[][] board, int i){
        Set<Character> columnSet =new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (columnSet.contains(board[j][i])){
                return false;
            }
            if(Character.isDigit(board[j][i])) {
                columnSet.add(board[j][i]);
            }
        }
        return true;
    }





    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]<=target && matrix[i][matrix[i].length-1]>=target){
                return isInCurrentArray(matrix[i], target);
            }
        }
        return false;
    }

    private boolean isInCurrentArray(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int middle;
        while (left<=right){
            middle = (left+right) / 2;
            if(matrix[middle]==target){
                return true;
            } else if(matrix[middle]>target){
                right  = middle-1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
//[".",".",".",".","5",".",".","1","."],
//        [".","4",".","3",".",".",".",".","."],
//        [".",".",".",".",".","3",".",".","1"],
//        ["8",".",".",".",".",".",".","2","."],
//        [".",".","2",".","7",".",".",".","."],
//        [".","1","5",".",".",".",".",".","."],
//        [".",".",".",".",".","2",".",".","."],
//        [".","2",".","9",".",".",".",".","."],
//        [".",".","4",".",".",".",".",".","."]]