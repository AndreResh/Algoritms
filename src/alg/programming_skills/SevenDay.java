package alg.programming_skills;

public class SevenDay {
    public static void main(String[] args) {

    }
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int j = 0, i = 0, k = mat.length-1; j < mat[0].length; j++, i++, k--) {
            if(i!=k){
                sum += mat[k][j];
            }
            sum += mat[i][j];
        }
        return sum;
    }
}
