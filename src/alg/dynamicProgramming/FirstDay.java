package alg.dynamicProgramming;

public class FirstDay {
    public static void main(String[] args) {

    }
    public int fib(int n) {
        if(n==0) return 0;
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i-2]+ints[i-1];
        }
        return ints[n];
    }
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 1;
        for (int i = 3; i < ints.length; i++) {
            ints[i] = ints[i-3] + ints[i-2]+ints[i-1];
        }
        return ints[n];
    }
}
